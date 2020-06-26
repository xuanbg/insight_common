package com.insight.basedata.report;

import com.insight.basedata.common.entity.Template;
import com.insight.utils.Json;
import com.insight.utils.pojo.LoginInfo;
import com.insight.utils.pojo.Reply;
import com.insight.utils.pojo.SearchDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author 宣炳刚
 * @date 2020/6/25
 * @remark 报表服务控制器
 */
@CrossOrigin
@RestController
@RequestMapping("/common/report")
public class ReportController {
    private final ReportService service;

    /**
     * 构造方法
     *
     * @param service ReportService
     */
    public ReportController(ReportService service) {
        this.service = service;
    }

    /**
     * 查询报表模板
     *
     * @param info 用户关键信息
     * @param dto  查询参数DTO
     * @return Reply
     */
    @GetMapping("/v1.0/templates")
    public Reply getTemplates(@RequestHeader("loginInfo") String info, SearchDto dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.getTemplates(loginInfo, dto);
    }

    /**
     * 获取报表模板详情
     *
     * @param info 用户关键信息
     * @param id   模板ID
     * @return Reply
     */
    @GetMapping("/v1.0/templates/{id}")
    public Reply getTemplate(@RequestHeader("loginInfo") String info, @PathVariable String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.getTemplate(loginInfo, id);
    }

    /**
     * 获取报表模板内容
     *
     * @param info 用户关键信息
     * @param id   模板ID
     * @return Reply
     */
    @GetMapping("/v1.0/templates/{id}/content")
    public Reply getTemplateContent(@RequestHeader("loginInfo") String info, @PathVariable String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.getTemplateContent(loginInfo, id);
    }

    /**
     * 导入报表模板
     *
     * @param info     用户关键信息
     * @param template 报表模板实体
     * @return Reply
     */
    @PostMapping("/v1.0/templates")
    public Reply importTemplate(@RequestHeader("loginInfo") String info, @RequestBody Template template) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.importTemplate(loginInfo, template);
    }

    /**
     * 复制报表模板
     *
     * @param info     用户关键信息
     * @param id       源模板ID
     * @param template 报表模板实体
     * @return Reply
     */
    @PostMapping("/v1.0/templates/{id}")
    public Reply copyTemplate(@RequestHeader("loginInfo") String info, @PathVariable String id, @RequestBody Template template) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.copyTemplate(loginInfo, id, template);
    }

    /**
     * 编辑报表模板
     *
     * @param info     用户关键信息
     * @param template 报表模板实体
     * @return Reply
     */
    @PutMapping("/v1.0/templates")
    public Reply editTemplate(@RequestHeader("loginInfo") String info, @RequestBody Template template) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.editTemplate(loginInfo, template);
    }

    /**
     * 设计报表模板
     *
     * @param info     用户关键信息
     * @param template 报表模板实体
     * @return Reply
     */
    @PutMapping("/v1.0/templates/content")
    public Reply designTemplate(@RequestHeader("loginInfo") String info, @RequestBody Template template) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.designTemplate(loginInfo, template);
    }

    /**
     * 禁用报表模板
     *
     * @param info 用户关键信息
     * @param id   模板ID
     * @return Reply
     */
    @PutMapping("/v1.0/templates/disable")
    public Reply disableTemplate(@RequestHeader("loginInfo") String info, @RequestBody String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.updateTemplateStatus(loginInfo, id, true);
    }

    /**
     * 启用报表模板
     *
     * @param info 用户关键信息
     * @param id   模板ID
     * @return Reply
     */
    @PutMapping("/v1.0/templates/enable")
    public Reply enableTemplate(@RequestHeader("loginInfo") String info, @RequestBody String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.updateTemplateStatus(loginInfo, id, false);
    }

    /**
     * 删除报表模板
     *
     * @param info 用户关键信息
     * @param id   模板ID
     * @return Reply
     */
    @DeleteMapping("/v1.0/templates")
    public Reply deleteTemplate(@RequestHeader("loginInfo") String info, @RequestBody String id) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.deleteTemplate(loginInfo, id);
    }

    /**
     * 获取日志列表
     *
     * @param info 用户关键信息
     * @param dto  查询参数DTO
     * @return Reply
     */
    @GetMapping("/v1.0/templates/logs")
    public Reply getLogs(@RequestHeader("loginInfo") String info, SearchDto dto) {
        LoginInfo loginInfo = Json.toBeanFromBase64(info, LoginInfo.class);

        return service.getLogs(loginInfo, dto);
    }

    /**
     * 获取日志详情
     *
     * @param id 日志ID
     * @return Reply
     */
    @GetMapping("/v1.0/templates/logs/{id}")
    public Reply getLog(@PathVariable String id) {
        return service.getLog(id);
    }
}