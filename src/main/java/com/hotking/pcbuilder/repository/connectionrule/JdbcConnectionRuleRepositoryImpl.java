package com.hotking.pcbuilder.repository.connectionrule;

import com.hotking.pcbuilder.entity.ConnectionRule;
import com.hotking.pcbuilder.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class JdbcConnectionRuleRepositoryImpl implements JdbcConnectionRuleRepository {

    private final NamedParameterJdbcTemplate namedJdbcTemplate;
    private final CategoryRepository categoryRepository;

    private static final String FIND_BY_SOURCE_AND_TARGET_CATEGORY_ID = """
            SELECT
                id,
                source_category_id,
                target_category_id,
                port_name
            FROM connection_rule
            WHERE source_category_id = :sourceId AND target_category_Id = :targetId
            """;

    private static final String FIND_BY_SOURCE_CATEGORY_ID = """
            SELECT
                id,
                source_category_id,
                target_category_id,
                port_name
            FROM connection_rule
            WHERE source_category_id = :sourceId
            """;

    @Override
    public List<ConnectionRule> findAllBySourceTargetCategory(Long sourceId, Long targetId) {
        var params = new MapSqlParameterSource(Map.of("sourceId", sourceId,
                                                      "targetId", targetId));
        //TODO исключение
        return namedJdbcTemplate.query(FIND_BY_SOURCE_AND_TARGET_CATEGORY_ID, params, (rs, rowNum) -> {
            return ConnectionRule.builder()
                    .sourceCategory(categoryRepository.findById(rs.getLong("source_category_id")).orElseThrow())
                    .targetCategory(categoryRepository.findById(rs.getLong("target_category_id")).orElseThrow())
                    .portName(rs.getString("port_name"))
                    .build();
        });
    }

    @Override
    public List<ConnectionRule> findAllBySourceCategory(Long sourceId) {
        var params = new MapSqlParameterSource(Map.of("sourceId", sourceId));
        //TODO исключение
        return namedJdbcTemplate.query(FIND_BY_SOURCE_CATEGORY_ID, params, (rs, rowNum) -> {
            return ConnectionRule.builder()
                    .sourceCategory(categoryRepository.findById(rs.getLong("source_category_id")).orElseThrow())
                    .targetCategory(categoryRepository.findById(rs.getLong("target_category_id")).orElseThrow())
                    .portName(rs.getString("port_name"))
                    .build();
        });
    }
}
