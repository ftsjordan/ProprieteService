package com.immolocationapp.proprieteservice;

import com.immolocationapp.proprieteservice.Repositories.PropertyRepository;
import com.immolocationapp.proprieteservice.entities.Apartment;
import com.immolocationapp.proprieteservice.entities.Property;
import com.immolocationapp.proprieteservice.entities.Shop;
import com.immolocationapp.proprieteservice.entities.Studio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class ProprieteServiceApplicationTests {

    @Autowired
    private PropertyRepository propertyRepository;

    @Test
    void contextLoads() {
    }

    @Test //insertion DB test
    void DataInsertion(){


        for (int i = 0; i < 200 ; i++) {
            double result= Math.random();
            System.out.println(result);

            if(result <= 0.3){
                Property apartment2=new Apartment("appartement "+UUID.randomUUID().toString(),"Centre","foundi","yaoundé 6","photo"+"i", (long) (result*50000),2L,false,2,2);
                if(result < 0.6) {
                     apartment2.setIsAvailable(true);
                    apartment2.setLessorId(3L);
                    apartment2.setDepartment("logola");
                    apartment2.setRegion("Nord");
                    apartment2.setDistrict("Mayo-sava");
                    propertyRepository.save(apartment2);
                }
                else{
                    propertyRepository.save(apartment2);
                }
            }
            if (result>0.3 && result<0.7){
                    Property studio = new Studio("studio"+UUID.randomUUID(),"centre","mfoundi","yaoundé 6","photo",20000L,1,false);
                    if(result<0.1) {
                        studio.setIsAvailable(true);
                        studio.setLessorId(2L);
                        studio.setDepartment("mayo");
                        studio.setDistrict("Ndongo");
                        propertyRepository.save(studio);
                    }
                    else{
                        propertyRepository.save(studio);
                    }
            }
            if(result>0.7) {
                    Property boutique = new Shop("boutique"+ UUID.randomUUID(), "centre", "mfoundi", "yaoundé 6", "photo", 20000L, 1, false);
                    if(result>0.2) {
                        boutique.setIsAvailable(true);
                        boutique.setLessorId(6L);
                        boutique.setRegion("littorale");
                        boutique.setDepartment("nyos");
                        propertyRepository.save(boutique);
                    }
                    else{
                        propertyRepository.save(boutique);
                    }
            }

        }
    }

    @Test
    //find by id lessor
    public void findProprieties(){

        Pageable pageable=PageRequest.of(0,1);
        List<Property> properties=propertyRepository.findByLessorId(1L,pageable).getContent();
        if(properties.isEmpty()) throw new RuntimeException("none property found");
        else{
            for (int i = 0; i < properties.size(); i++) {
                System.out.println(properties.get(i).getProprietyName());
            }
        }
    }

    @Test
    //find properties whose is not occupied by a tenant
    //it means that we will look for properties whose attribute isAvailable equal to true
    public void availableProperties(){

        Pageable pageable=PageRequest.of(0,1000);
        List<Property> properties=propertyRepository.findByAvailableIsTrue(pageable).getContent();
        if(properties.isEmpty()) throw new RuntimeException("none property found");
        else{
            for (int i = 0; i < properties.size(); i++) {
                System.out.println(properties.get(i).getProprietyName());
            }
        }

    }
}
