package org.gus.armstrong_gym.controller;

import java.net.URI;
import java.util.List;

import org.gus.armstrong_gym.domain.model.Address;
import org.gus.armstrong_gym.domain.model.Member;
import org.gus.armstrong_gym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/members")
public class MemberController {
  
  @Autowired
  MemberService memberService;

  @GetMapping
  public ResponseEntity<List<Member>> getMembers(){
    var memberList = memberService.findAll();
    return ResponseEntity.ok(memberList);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Member> findOneMember(@PathVariable Long id){
    var member = memberService.findById(id);
    return ResponseEntity.ok(member);
  }

  @PostMapping
  public ResponseEntity<Member> createMember(@RequestBody Member member){
    Address address = member.getAddress();
    address.setMember(member);
    var createdMember = memberService.createMember(member);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdMember.getId())
            .toUri();

    return ResponseEntity.created(location).body(createdMember);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member){
    var updatedMember = memberService.updateMember(id, member);
    return ResponseEntity.ok(updatedMember);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long id){
    memberService.deleteMember(id);
    return ResponseEntity.noContent().build();
  }
}
