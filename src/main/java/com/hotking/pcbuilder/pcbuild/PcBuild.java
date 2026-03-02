package com.hotking.pcbuilder.pcbuild;

import com.hotking.pcbuilder.entity.ConnectionRule;
import com.hotking.pcbuilder.entity.Port;
import com.hotking.pcbuilder.entity.Product;
import com.hotking.pcbuilder.service.ConnectionRuleService;
import com.hotking.pcbuilder.service.PortService;
import com.hotking.pcbuilder.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;
//TODO : сделать аспектами добавления категорий и слотов
@Build
@Component
@RequiredArgsConstructor
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
        return categories.containsKey(id);
    }

    public boolean containsEmptySlots(String slotName){
        return emptySlots.get(slotName) >= 0;
    }

    public boolean validateComponent(Product product){
        build.putIfAbsent(product.getId(), 0);
        build.put(product.getId(), build.get(product.getId()) + 1);
        categories.putIfAbsent(product.getCategory().getId(), 0);
        categories.put(product.getCategory().getId(), categories.get(product.getCategory().getId()) + 1);
        String portName = connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName();
        List<Port>ports = portService.findAllByProductId(product.getId());
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) continue;
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) + ports.get(i).getPortNum());
        }

        if(emptySlots.containsKey(portName))emptySlots.put(portName, emptySlots.get(portName) - 1);
        boolean valid = validator.isValid(this, product);
        removeComponent(product.getId());
        return valid;
    }


    public PcBuild addComponent(Product product){
        categories.putIfAbsent(product.getCategory().getId(), 0);
        categories.put(product.getCategory().getId(), categories.get(product.getCategory().getId()) + 1);
        List<Port>ports = portService.findAllByProductId(product.getId());
        String portName = connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) continue;
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) + ports.get(i).getPortNum());
        }
        ConnectionRule thisPort = connectionRuleService.findBySourceCategory(product.getCategory().getId());
        build.putIfAbsent(product.getId(), 0);
        lastAdded = product.getId();
        build.put(product.getId(), build.get(product.getId()) + 1);
        if(emptySlots.containsKey(thisPort.getPortName()))emptySlots.put(thisPort.getPortName(), emptySlots.get(thisPort.getPortName()) - 1);
        return this;
    }

    public void removeComponent(Long id){
        Product product = productService.findByIdEntity(id);
        categories.put(product.getCategory().getId(), categories.get(product.getCategory().getId()) - 1);
        build.put(id, build.get(id) - 1);
        List<Port>ports = portService.findAllByProductId(productService.findByIdEntity(id).getId());
        String portName = connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) continue;
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) - ports.get(i).getPortNum());
        }

        if(emptySlots.containsKey(connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName())) {
            emptySlots.put(connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName(), emptySlots.get(connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName()) + 1);
        }
    }

    public void removeLastComponent(){
        if(lastAdded == -1) return;

        Long categoryId = productService.findByIdEntity(lastAdded).getCategory().getId();
        build.put(lastAdded, build.get(lastAdded) - 1);
        categories.put(categoryId, categories.get(categoryId) - 1);
        List<Port>ports = portService.findAllByProductId(productService.findByIdEntity(lastAdded).getId());
        Product product = productService.findByIdEntity(lastAdded);
        String portName = connectionRuleService.findBySourceCategory(product.getCategory().getId()).getPortName();
        for (int i = 0; i < ports.size(); i++) {
            if(portName.equals(ports.get(i).getPortName())) continue;
            emptySlots.putIfAbsent(ports.get(i).getPortName(), 0);
            emptySlots.put(ports.get(i).getPortName(), emptySlots.get(ports.get(i).getPortName()) - ports.get(i).getPortNum());
        }

        if(emptySlots.containsKey(connectionRuleService.findBySourceCategory(lastAdded).getPortName()))emptySlots.put(connectionRuleService.findBySourceCategory(lastAdded).getPortName(), emptySlots.get(connectionRuleService.findBySourceCategory(lastAdded).getPortName()) + 1);
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
