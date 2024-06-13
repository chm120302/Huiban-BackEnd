package com.example.huibanbackend.controller;


import com.example.huibanbackend.entity.*;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.service.FollowListService;
import com.example.huibanbackend.service.JournalService;
import com.example.huibanbackend.service.UserService;
import com.example.huibanbackend.utils.WebUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest userHttpRequest;

    @GetMapping("/popularList")
    @Operation(summary = "get the top 5 followed journals ")
//    @PreAuthorize("@myAccess.hasAuthority('32')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<JournalDetail>> getPopularJournals() {
        return Result.Success("get popular", journalService.getPopularList());
    }

//    @GetMapping("/recentList")
//    @Operation(summary = "get the 10 journals with the latest deadlines")
//    @PreAuthorize("@myAccess.hasAuthority('31')")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "请求成功"),
//            @ApiResponse(responseCode = "401", description = "没有权限"),
//            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
//    })
//    public Result<List<JournalShow>> getRecentJournals() {
//        return Result.Success("get recent", journalService.getRecentList());
//    }

    @GetMapping("/list")
    @Operation(summary = "get all journals")
    @PreAuthorize("@myAccess.hasAuthority('33')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<JournalShow>> getAllJournals() {
        return Result.Success("get", journalService.getAllShow());
    }

    @GetMapping("/list/{journalId}")
    @Operation(summary = "get journal show information by id")
    @PreAuthorize("@myAccess.hasAuthority('34')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<JournalShow> getJournal(@PathVariable String journalId) {
        try{
            JournalShow js = journalService.getById(journalId);
            return Result.Success("get", js);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @GetMapping("/list/rank/{ccfRank}")
    @Operation(summary = "get journal show information by ccf rank")
    @PreAuthorize("@myAccess.hasAuthority('37')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<JournalShow>> getJournalByCcfRank(@PathVariable String ccfRank){
        return Result.Success("get", journalService.getByCCFRank(ccfRank));
    }

    @GetMapping("/list/sub/{sub}")
    @Operation(summary = "get journal show information by sub")
    @PreAuthorize("@myAccess.hasAuthority('36')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<JournalShow>> getJournalBySub(@PathVariable String sub){
        return Result.Success("get", journalService.getBySub(sub));
    }

    @GetMapping("/list/detail")
    @Operation(summary = "get all journals' details")
    @PreAuthorize("@myAccess.hasAuthority('38')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<JournalDetail>> getAllJournalDetails() {
        return Result.Success("get", journalService.getAllDetail());
    }
    
    @GetMapping("/list/{journalId}/detail")
    @Operation(summary = "get journal detail by id")
    @PreAuthorize("@myAccess.hasAuthority('35')")
    public Result<JournalDetail> getJournalDetail(@PathVariable String journalId) {
        try{
            JournalDetail jd = journalService.getDetailById(journalId);
            return Result.Success("get", jd);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


    @PostMapping
    @Operation(summary = "add journal")
    @PreAuthorize("@myAccess.hasAuthority('30')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public Result<Journal> addJournal(@RequestBody Journal journal) {
        try{
            journalService.insert(journal);
            return Result.Success("add", journal);
        }catch (DuplicateException e){
            return Result.fail(HttpStatus.CONFLICT.value(), "duplicate", null);
        }
    }

    
    @DeleteMapping("/{journalId}")
    @Operation(summary = "delete journal")
    @PreAuthorize("@myAccess.hasAuthority('39')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<Void> deleteJournal(@PathVariable String journalId) {
        try{
            journalService.delete(journalId);
            return Result.Success("delete", journalId);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


    @PutMapping("/update")
    @Operation(summary = "update journal information")
    @PreAuthorize("@myAccess.hasAuthority('29')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<Journal> updateJournal(@RequestBody Journal journal){
        try{
            journalService.update(journal);
            return Result.Success("update", journal);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


    @PutMapping("/{journalId}/follow/add")
    @Operation(summary = "add follow number of journal")
    @PreAuthorize("@myAccess.hasAuthority('28')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> addFollowNum(@PathVariable String journalId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            journalService.addFollowNum(journalId);
            FollowList ft = new FollowList(email, "journal", journalId);
            followListService.insertJour(ft);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("add follow, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/{journalId}/follow/sub")
    @Operation(summary = "sub follow number of journal")
    @PreAuthorize("@myAccess.hasAuthority('27')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> subFollowNum(@PathVariable String journalId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            journalService.subFollowNum(journalId);
            followListService.deleteJour(journalId, email);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("sub follow, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }




}
