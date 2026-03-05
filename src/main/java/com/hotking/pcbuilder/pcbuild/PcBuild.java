package com.hotking.pcbuilder.pcbuild;

import com.hotking.pcbuilder.entity.ConnectionRule;
import com.hotking.pcbuilder.entity.Port;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.service.ConnectionRuleService;
import com.hotking.pcbuilder.service.PortService;
import com.hotking.pcbuilder.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.*;
//TODO : сделать аспектами добавления категорий и слотов
@Build
@Component
@RequiredArgsConstructor
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PcBuild {

    //id продукта, количество комплектующего
    private Map<Long, Integer> build = new LinkedHashMap<>();
    //имя порта, количество оставшихся мест
    private Map<String, Integer>emptySlots = new HashMap<>();
    //id категории, количество комплектующих в категории
    private Map<Long, Integer> categories = new HashMap<>();
    @Getter
    Long lastAdded = -1L;
    private final BuildCompletenessValidator validator;
    private final ProductService productService;
    private final PortService portService;
    private final ConnectionRuleService connectionRuleService;

    public boolean containsCategory(Long id){
        return categories.containsKey(id) && categories.get(id) > 0;
    }

    public boolean containsEmptySlots(String slotName){
        return emptySlots.containsKey(slotName) && emptySlots.get(slotName) >= 0;
    }

    public boolean validateComponent(Product product){
        addComponent(product);
        boolean valid = validator.isValid(this, product);
        removeComponent(product.getId());
        return valid;
    }


    public PcBuild addComponent(Product product){
        categories.putIfAbsent(product.getCategory().getId(), 0);
        categories.put(product.getCategory().getId(), categories.get(product.getCategory().getId()) + 1);
        List<Port>ports = portService.findAllByProductId(product.getId());
        ConnectionRule rule = connectionRuleService.findBySourceCategory(product.getCategory().getId());
        String portName = rule.getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) {
                emptySlots.put(portName, emptySlots.getOrDefault(portName, 0) - ports.get(i).getPortNum());
                continue;
            }
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) + ports.get(i).getPortNum());
        }
        ConnectionRule thisPort = connectionRuleService.findBySourceCategory(product.getCategory().getId());
        build.putIfAbsent(product.getId(), 0);
        lastAdded = product.getId();
        build.put(product.getId(), build.get(product.getId()) + 1);
//        if(emptySlots.containsKey(portName) && categories.containsKey(rule.getTargetCategory().getId()) && categories.get(rule.getTargetCategory().getId()) > 0){
//            emptySlots.put(portName, emptySlots.get(portName) - 1);
//        }
        return this;
    }

    public void removeComponent(Long id){
        Product product = productService.findByIdEntity(id);
        categories.put(product.getCategory().getId(), categories.get(product.getCategory().getId()) - 1);
        build.put(id, build.get(id) - 1);
        List<Port>ports = portService.findAllByProductId(productService.findByIdEntity(id).getId());
        ConnectionRule rule = connectionRuleService.findBySourceCategory(product.getCategory().getId());
        String portName = rule.getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) {
                emptySlots.put(portName, emptySlots.getOrDefault(portName, 0) + ports.get(i).getPortNum());
                continue;
            }
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) - ports.get(i).getPortNum());
        }

//        if(emptySlots.containsKey(portName) && categories.containsKey(rule.getTargetCategory().getId()) && categories.get(rule.getTargetCategory().getId()) > 0){
//            emptySlots.put(portName, emptySlots.get(portName) + 1);
//        }
    }

    public void removeLastComponent(){
        if(lastAdded == -1) return;

        Long categoryId = productService.findByIdEntity(lastAdded).getCategory().getId();
        build.put(lastAdded, build.get(lastAdded) - 1);
        categories.put(categoryId, categories.get(categoryId) - 1);
        List<Port>ports = portService.findAllByProductId(productService.findByIdEntity(lastAdded).getId());
        Product product = productService.findByIdEntity(lastAdded);
        ConnectionRule rule = connectionRuleService.findBySourceCategory(product.getCategory().getId());
        String portName = rule.getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) {
                emptySlots.put(portName, emptySlots.getOrDefault(portName, 0) + ports.get(i).getPortNum());
                continue;
            }
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) - ports.get(i).getPortNum());
        }

//        if(emptySlots.containsKey(portName) && categories.containsKey(rule.getTargetCategory().getId()) && categories.get(rule.getTargetCategory().getId()) > 0){
//            emptySlots.put(portName, emptySlots.get(portName) + 1);
//        }
    }

    public LinkedList<Product> get(){

        LinkedList<Product> products = new LinkedList<>();
        for (var entry : build.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                products.add(productService.findByIdEntity(entry.getKey()));
            }
        }

        return products;
    }
}
