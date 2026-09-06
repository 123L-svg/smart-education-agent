package com.smarteducation.aigc.agent;

import cn.hutool.core.map.MapUtil;
import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.utils.JsonUtils;
import io.reactivex.Flowable;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class AppTest {

    @Test

    public void testAppCall() throws Exception {
        // 构造业务参数
        String token = "\n" +
                "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjp7InVzZXJJZCI6Miwicm9sZUlkIjoyLCJyZW1lbWJlck1lIjpmYWxzZX0sImV4cCI6MTc4NzAyOTQyN30.FOfp6YXzsHTNL_tLTwxAsTzb3B8aZwV0fmNXbdzB84uohfAJSS65g6zpf8PD3ErXd90cyx23Wx0Pp4_I0TBI6cSo8CbglHZwd1JQ3wgxOei2LiUaNPKqQVM7ZasHjlxyvb-6ZecQQXJioLTw_N90PDOZT2eqvNw0OiaVA_x3SMG7mLDfr1i5MwDyqisn_QXF6FKaG6bBOl8x_N8ESwr1-PCPDk2d_fglXKBwvbT7HP391YBTQ97T-eLxg5iBuneaB4IeZyESvHanFBXdP6KTUdpheTp9JDt78cYQy3a81FF-C35GzDjVr11BCnBzKIQ14UH3cJ-LwYUu_VJblOHFwA";
        Map<String, Object> bizParams = MapUtil.<String, Object>builder()
                .put("user_defined_tokens", MapUtil.of("tool_xxxxx", // 工具id
                        MapUtil.of("user_token", token)))
                .build();

        // bizParams.add("user_defined_tokens", JsonObject);
        ApplicationParam param = ApplicationParam.builder()
                // 若没有配置环境变量，可用百炼API Key将下行替换为：.apiKey("sk-xxx")。但不建议在生产环境中直接将API Key硬编码到代码中，以减少API Key泄露风险。
                .apiKey("sk-xxxxxx")
                .appId("xxxxxxxxxx") // 智能体id
                .prompt("查询课程，id为：1880533253575225346")
                .incrementalOutput(true) // 开启增量输出
                .bizParams(JsonUtils.toJsonObject(bizParams))
                .build();

        Application application = new Application();
        Flowable<ApplicationResult> result = application.streamCall(param);

        // 阻塞式的打印内容
        result.blockingForEach(data -> {
            System.out.printf("%s\n",data.getOutput().getText());
        });

    }

}
