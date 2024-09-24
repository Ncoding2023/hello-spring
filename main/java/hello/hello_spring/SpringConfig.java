package hello.hello_spring;

import hello.hello_spring.Service.MemberService;
import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.JdbcMemberRepository;
import hello.hello_spring.repository.JdbcTemplateMemberRepository;
import hello.hello_spring.repository.JpaMemberRepository;
import hello.hello_spring.repository.MemberRepository;
//import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    /*
    *jdbc방식
    *private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*
    *jpa 방식
    * private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired // 생성자 1개면 어너테이션없어도 됨
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService()    {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }
    @Bean
    public TimeTraceAop timeTraceAop()    {
        return new TimeTraceAop();
    }
//    @Bean
//    public MemberRepository memberRepository()    {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
