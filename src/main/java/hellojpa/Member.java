package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
//@SequenceGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        sequenceName = "MEMBER_SEQ",
//        initialValue = 1, allocationSize = 50  )
//@TableGenerator(  )
public class Member {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성을 데이터베이스에 위임, 이 전략일땐 persist때 업데이트 일어남(커밋때 말고)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") //ex 오라클 시퀀스 전략, persist때 nextVal을 가져옴, 커밋때 업데이트
    //@GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private String username;

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }
}