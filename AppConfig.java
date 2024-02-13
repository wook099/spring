package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {//애플리케이션 전반에 대한 구성을 책임짐
//@bean -> memService -> new mmr
    @Bean//하면 스프링컨테이너에 등록이 됨
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());//생성자 주입
        //생성자를 통해 객체가 뉴 인스턴스 생성된게 들어가는것
    }

    @Bean//스프릥 컨테이너에 등록된 객체를 스프링 빈이라고 한다.
    public static MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
