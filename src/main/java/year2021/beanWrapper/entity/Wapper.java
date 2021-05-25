package year2021.beanWrapper.entity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class Wapper {


    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setDuration(1);

        Entity targetEntity = new Entity();
        targetEntity.setName("ddd");
        BeanUtils.copyProperties(entity,targetEntity,getNullPropertyNames(entity));
        System.out.println(targetEntity.getName());
    }


    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);



    }
}
