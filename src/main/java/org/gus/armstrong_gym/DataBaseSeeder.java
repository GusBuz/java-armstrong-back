package org.gus.armstrong_gym;

import org.gus.armstrong_gym.domain.model.Address;
import org.gus.armstrong_gym.domain.model.Member;
import org.gus.armstrong_gym.domain.model.enums.PaymentPlan;
import org.gus.armstrong_gym.service.MemberService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseSeeder {

    @Bean
    CommandLineRunner init(MemberService memberService) {
        return args -> {

            Address address = new Address(
                "12312312",
                "Rua fedor",
                "123",
                "",
                "Vila dos gatos",
                "Peidos",
               "Peido");

            Member member = new Member(
                "Quill",
                "12312312312",
                "112311231",
                "quill@email.com",
                address,
                PaymentPlan.MONTHLY);
            address.setMember(member);
            memberService.createMember(member);            
        };
    }
}
