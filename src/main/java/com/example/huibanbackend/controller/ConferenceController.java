package com.example.huibanbackend.controller;

import com.example.huibanbackend.entity.*;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.ConferenceMapper;
import com.example.huibanbackend.service.AttendListService;
import com.example.huibanbackend.service.ConferenceService;
import com.example.huibanbackend.service.FollowListService;
import com.example.huibanbackend.service.UserService;
import com.example.huibanbackend.utils.JwtTokenUtils;
import com.example.huibanbackend.utils.WebUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Tag(name = "conference controller", description = "测试conference相关接口")
@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @Autowired
    private FollowListService followListService;

    @Autowired
    private AttendListService attendListService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest userHttpRequest;


    @GetMapping("/popularList")
    @Operation(summary = "get the top 5 followed conferences ")
//    @PreAuthorize("@myAccess.hasAuthority('14')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceDetail>> getPopularConferences(){
        return Result.Success("get popular", conferenceService.getPopularList());

    }


    @GetMapping("/recentList")
    @Operation(summary = "get the 10 conferences with the latest deadlines")
//    @PreAuthorize("@myAccess.hasAuthority('13')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getRecentConferences() {
        return Result.Success("get recent", conferenceService.getRecentList());

    }


    @GetMapping("/list")
    @PreAuthorize("@myAccess.hasAuthority('15')")
    @Operation(summary = "get all conferences")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getAllConferences() {
        return Result.Success("get all", conferenceService.getAllShow());

    }


    @GetMapping("/list/{conferenceId}")
    @Operation(summary = "get conference show information by id")
    @PreAuthorize("@myAccess.hasAuthority('16')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<ConferenceShow> getConference(@PathVariable String conferenceId) {
        try{
            ConferenceShow cs = conferenceService.getById(conferenceId);
            return Result.Success("get", cs);

        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


    @GetMapping("/list/rank/{ccfRank}")
    @Operation(summary = "get conference show information by ccf rank")
    @PreAuthorize("@myAccess.hasAuthority('20')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getConferenceByCcfRank(@PathVariable String ccfRank) {
        return Result.Success("get", conferenceService.getByCCFRank(ccfRank));
    }


    @GetMapping("/list/title/{title}")
    @Operation(summary = "get conference show information by title")
    @PreAuthorize("@myAccess.hasAuthority('18')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getConferenceByTitle(@PathVariable String title) {
        return Result.Success("get", conferenceService.getByTitle(title));
    }


    @GetMapping("/list/sub/{sub}")
    @Operation(summary = "get conference show information by sub")
    @PreAuthorize("@myAccess.hasAuthority('19')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getConferenceBySub(@PathVariable String sub) {
        return Result.Success("get", conferenceService.getBySub(sub));
    }


    @GetMapping("/list/")
    @Operation(summary = "get conference show information with the startTime between startDate and endDate")
    @PreAuthorize("@myAccess.hasAuthority('22')")
    @Parameters({@Parameter(name = "startDate", description = "start date"), @Parameter(name = "endDate", description = "end date")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceShow>> getByPeriod(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam @Parameter Date startDate,  @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam @Parameter Date endDate) {
        return Result.Success("get",conferenceService.getByPeriod(startDate, endDate));
    }

    @GetMapping("/list/detail")
    @Operation(summary = "get all conferences' details")
    @PreAuthorize("@myAccess.hasAuthority('21')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<ConferenceDetail>> getAllConferenceDetails(){
        return Result.Success("get", conferenceService.getAllDetail());
    }


    @GetMapping("/list/{conferenceId}/detail")
    @Operation(summary = "get conference detail by id")
    @PreAuthorize("@myAccess.hasAuthority('17')")
    public Result<ConferenceDetail> getConferenceDetail(@PathVariable String conferenceId){
        try{
            ConferenceDetail cd = conferenceService.getDetailById(conferenceId);
            return Result.Success("get", cd);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }


    @PostMapping
    @Operation(summary = "add conference")
    @PreAuthorize("@myAccess.hasAuthority('12')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "201", description = "已创建,成功请求并创建了新的资源"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对"),
            @ApiResponse(responseCode = "409", description = "服务器在完成请求时发生冲突")
    })
    public Result<Conference> addConference(@RequestBody Conference conference) {
         try{
             conferenceService.insert(conference);
             return Result.Success("add", conference);
         }catch (DuplicateException e){
             return Result.fail(HttpStatus.CONFLICT.value(), "duplicate", null);
         }
    }


    @DeleteMapping("/{conferenceId}")
    @PreAuthorize("@myAccess.hasAuthority('23')")
    @Operation(summary = "delete conference")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "204", description = "服务器成功处理，但未返回内容"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<Void> deleteConference(@PathVariable String conferenceId) {
        try{
            conferenceService.delete(conferenceId);
            return Result.Success("delete", conferenceId);
        }catch (NotFoundException e){
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/update")
    @Operation(summary = "update conference information")
    @PreAuthorize("@myAccess.hasAuthority('11')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    public Result<Conference> updateConference(@RequestBody Conference conference) {
        try {
            conferenceService.update(conference);
            return Result.Success("update", conference);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/{conferenceId}/follow/add")
    @Operation(summary = "add follow number of conference")
    @PreAuthorize("@myAccess.hasAuthority('8')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> addFollowNum(@PathVariable String conferenceId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            conferenceService.addFollowNum(conferenceId);
            FollowList ft = new FollowList(email, "conference", conferenceId);
            followListService.insertConf(ft);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("add follow, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/{conferenceId}/follow/sub")
    @Operation(summary = "sub follow number of conference")
    @PreAuthorize("@myAccess.hasAuthority('7')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> subFollowNum(@PathVariable String conferenceId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            conferenceService.subFollowNum(conferenceId);
            followListService.deleteConf(conferenceId, email);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("sub follow, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/{conferenceId}/attend/add")
    @Operation(summary = "add attend number of conference")
    @PreAuthorize("@myAccess.hasAuthority('10')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> addAttendNum(@PathVariable String conferenceId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            conferenceService.addAttendNum(conferenceId);
            AttendList att = new AttendList(email, "conference", conferenceId);
            attendListService.insertConf(att);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("add attend, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }

    @PutMapping("/{conferenceId}/attend/sub")
    @Operation(summary = "sub attend number of conference")
    @PreAuthorize("@myAccess.hasAuthority('9')")
    @Parameters(@Parameter(name = "email", description = "user email"))
    public Result<Void> subAttendNum(@PathVariable String conferenceId){
        try{
            String email = WebUtils.getEmailFromHeader(userHttpRequest);
            conferenceService.subAttendNum(conferenceId);
            attendListService.deleteConf(conferenceId, email);
            User user = userService.getAllInfoByEmail(email);
            return Result.Success("sub attend, return user's info", user);
        } catch (NotFoundException e) {
            return Result.fail(HttpStatus.NOT_FOUND.value(), "not found", null);
        }
    }








}
