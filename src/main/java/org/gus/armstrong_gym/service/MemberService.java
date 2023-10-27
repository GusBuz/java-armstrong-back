package org.gus.armstrong_gym.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.gus.armstrong_gym.domain.model.Member;
import org.gus.armstrong_gym.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  MemberRepository memberRepository;

  public List<Member> findAll(){
    return memberRepository.findAll();
  }
  
  public Member findById(Long id) {
    return memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  public Member createMember(Member member) {
    if(member.getId() != null && memberRepository.existsById(member.getId())){
      throw new IllegalArgumentException("This member already exists.");
    }
    return memberRepository.save(member);
  }

  public void deleteMember(Long id){
    memberRepository.deleteById(id);
  }

  public Member updateMember(Long id, Member newMember){
    Member updatedMember = memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    updatedMember.updateMember(newMember);    
    return memberRepository.save(updatedMember);
  }
}
