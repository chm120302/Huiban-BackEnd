package com.example.huibanbackend.controller;


import com.example.huibanbackend.entity.*;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.service.FollowListService;
import com.example.huibanbackend.service.JournalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "journal controller", description = "测试journal相关接口")
@RestController
@RequestMapping("/api/journals")
public class JournalController {
    
    @Autowired
    private JournalService journalService;

    @Autowired
    private FollowListService followListService;

    @GetMapping("/popularList")
    @Operation(summary = "get the top 5 followed journals ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalDetail>> getPopularJournals() {
        return ResponseEntity.ok(journalService.getPopularList());
    }

    @GetMapping("/recentList")
    @Operation(summary = "get the 10 journals with the latest deadlines")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalShow>> getRecentJournals() {
        return ResponseEntity.ok(journalService.getRecentList());
    }

    @GetMapping("/list")
    @Operation(summary = "get all journals")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalShow>> getAllJournals() {
        return ResponseEntity.ok(journalService.getAllShow());
    }

    @GetMapping("/list/{journalId}")
    @Operation(summary = "get journal show information by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<JournalShow> getJournal(@PathVariable String journalId) {
        try{
            JournalShow js = journalService.getById(journalId);
            return ResponseEntity.ok(js);
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/list/rank/{ccfRank}")
    @Operation(summary = "get journal show information by ccf rank")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalShow>> getJournalByCcfRank(@PathVariable String ccfRank){
        return ResponseEntity.ok(journalService.getByCCFRank(ccfRank));
    }

    @GetMapping("/list/sub/{sub}")
    @Operation(summary = "get journal show information by sub")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalShow>> getJournalBySub(@PathVariable String sub){
        return ResponseEntity.ok(journalService.getBySub(sub));
    }

    @GetMapping("/list/detail")
    @Operation(summary = "get all journals' details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<List<JournalDetail>> getAllJournalDetails() {
        return ResponseEntity.ok(journalService.getAllDetail());
    }
    
    @GetMapping("/list/{journalId}/detail")
    @Operation(summary = "get journal detail by id")
    public ResponseEntity<JournalDetail> getJournalDetail(@PathVariable String journalId) {
        try{
            JournalDetail jd = journalService.getDetailById(journalId);
            return ResponseEntity.ok(jd);
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
        }
    }


    @PostMapping
    @Operation(summary = "add journal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public ResponseEntity<Journal> addJournal(@RequestBody Journal journal) {
        try{
            journalService.insert(journal);
            return ResponseEntity.status(HttpStatus.CREATED).body(journal);
        }catch (DuplicateException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    
    @DeleteMapping("/{journalId}")
    @Operation(summary = "delete journal")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Void> deleteJournal(@PathVariable String journalId) {
        try{
            journalService.delete(journalId);
            return ResponseEntity.noContent().build();
        }catch (NotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PutMapping("/update")
    @Operation(summary = "update journal information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public ResponseEntity<Journal> updateJournal(@RequestBody Journal journal){
        try{
            journalService.update(journal);
            return ResponseEntity.ok(journal);
        }catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{journalId}/follow/add")
    @Operation(summary = "add follow number of journal")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> addFollowNum(@PathVariable String journalId, @RequestParam @Parameter String email){
        try{
            journalService.addFollowNum(journalId);
            FollowList ft = new FollowList(email, "journal", journalId);
            followListService.insertJour(ft);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{journalId}/follow/sub")
    @Operation(summary = "sub follow number of journal")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public ResponseEntity<Void> subFollowNum(@PathVariable String journalId, @RequestParam @Parameter String email){
        try{
            journalService.subFollowNum(journalId);
            followListService.deleteJour(journalId, email);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }




}
