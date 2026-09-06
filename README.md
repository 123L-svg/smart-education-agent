# 智慧教育多 Agent 问答辅助系统

在线教育平台后端微服务系统，基于 **Spring Boot 3** + **Spring Cloud Alibaba** + **Spring AI** 构建，支持课程管理、学习进度、考试评测、订单支付、多 Agent 智能问答等完整业务流程。

---

## 技术架构

### 核心技术

| 类别 | 技术 | 版本 |
|------|------|------|
| 基础框架 | Spring Boot | 3.3.5 |
| 微服务治理 | Spring Cloud + Alibaba | 2023.0.3 / 2023.0.3.2 |
| 服务注册 & 配置 | Nacos | — |
| API 网关 | Spring Cloud Gateway | — |
| 熔断降级 | Sentinel | — |
| 分布式事务 | Seata | 1.5.1 |
| 定时任务 | XXL-Job | 2.3.1 |
| ORM | MyBatis Plus | 3.5.9 |
| 数据库 | MySQL | 8.0 |
| 缓存 & 分布式锁 | Redis + Redisson | 3.13.6 |
| 搜索引擎 | Elasticsearch | 7.12.1 |
| 消息队列 | RabbitMQ | — |
| 文档接口 | Knife4j (Swagger) | 2.2.19 |
| 工具库 | Hutool | 5.8.36 |

### AI 能力

| 类别 | 技术 |
|------|------|
| AI 框架 | Spring AI 1.0.0 |
| 大模型 | 通义千问 (DashScope) |
| 向量存储 | Elasticsearch / Redis |
| 多智能体 | RouteAgent / RecommendAgent / ConsultAgent / BuyAgent / KnowledgeAgent |

### 云服务

| 类别 | 技术 |
|------|------|
| 阿里云 | KMS 密钥管理、OSS 对象存储、短信服务、支付宝支付 |
| 腾讯云 | COS 对象存储、VOD 视频点播 |

---

## 模块结构

```
smart-education-agent
├── dm-gateway      # API 网关 — 统一入口，路由分发
├── dm-api           # Feign 接口定义 — 服务间 RPC 调用契约
├── dm-common        # 公共模块 — 基础工具、XXL-Job、通用配置
├── dm-auth          # 认证授权 — 登录、Token、权限校验
├── dm-user          # 用户服务 — 学生/教师/管理员
├── dm-course        # 课程服务 — 课程 CRUD、分类、标签
├── dm-learning      # 学习服务 — 学习进度、课时记录、AI 问答
├── dm-exam          # 考试服务 — 题库管理、组卷、批改
├── dm-message       # 消息服务 — 短信、站内信、通知
├── dm-media         # 媒体服务 — 视频上传、转码、播放
├── dm-search        # 搜索服务 — 课程/内容全文检索
├── dm-pay           # 支付服务 — 支付宝对接、支付流水
├── dm-trade         # 交易服务 — 订单管理、退款
├── dm-promotion     # 营销服务 — 优惠券、限时折扣
├── dm-data          # 数据服务 — 学习统计、数据看板
├── dm-remark        # 评价服务 — 课程评分、评论
└── dm-aigc          # AI 智能体 — 多智能体对话、课程推荐 ✨
```

---

## AI 智能体模块 (dm-aigc)

基于 **Spring AI** 实现的多智能体协作系统，通过路由分发的模式，将用户意图路由到不同的专业智能体：

```
用户请求 → RouteAgent（意图识别）
              ├── RecommendAgent  → 个性化课程推荐
              ├── ConsultAgent    → 课程咨询、学习答疑
              ├── BuyAgent        → 下单引导、优惠查询
              └── KnowledgeAgent  → 知识库 RAG 检索
```

### 核心特性

- **多智能体协作**：根据用户意图自动路由到对应智能体处理
- **RAG 检索增强**：基于 Elasticsearch / Redis 向量存储的知识库问答
- **对话记忆**：Redis 持久化会话历史，支持多轮对话
- **流式输出**：支持 SSE 实时推送 AI 回复内容
- **语音交互**：集成语音识别与合成接口

### 智能体说明

| 智能体 | 功能 |
|--------|------|
| `RouteAgent` | 意图识别，将用户请求分发到对应的专业智能体 |
| `RecommendAgent` | 根据用户学习历史推荐课程 |
| `ConsultAgent` | 回答课程相关内容、学习问题 |
| `BuyAgent` | 引导用户完成课程购买流程 |
| `KnowledgeAgent` | 基于向量数据库进行知识检索增强生成 |

---

## 服务路由

所有请求通过 Gateway (`10010`) 统一入口，按路径前缀路由：

| 前缀 | 目标服务 | 说明 |
|------|----------|------|
| `/as/**` | auth-service | 认证授权 |
| `/us/**` | user-service | 用户管理 |
| `/cs/**` | course-service | 课程管理 |
| `/ls/**` | learning-service | 学习记录 |
| `/ms/**` | media-service | 媒体资源 |
| `/sms/**` | message-service | 短信通知 |
| `/ss/**` | search-service | 搜索查询 |
| `/os/**` | order-service | 交易订单 |
| `/ds/**` | data-service | 数据统计 |

---

## 环境要求

| 软件 | 最低版本 |
|------|----------|
| JDK | 17+ |
| Maven | 3.8+ |
| MySQL | 8.0+ |
| Redis | 6.0+ |
| Elasticsearch | 7.12+ |
| RabbitMQ | 3.x+ |
| Nacos | 2.x+ |

---

## 快速开始

### 1. 克隆项目

```bash
git clone https://github.com/123L-svg/smart-education-agent.git
cd smart-education-agent
```

### 2. 配置环境

确保 Nacos、MySQL、Redis、Elasticsearch、RabbitMQ 已启动，然后修改各模块 `application-*.yml` 中的连接信息。

### 3. 编译

```bash
mvn clean install -DskipTests
```

### 4. 启动服务

建议按以下顺序启动：

```bash
# 1. 基础设施（确保已启动）
# Nacos + MySQL + Redis + ES + RabbitMQ

# 2. 基础服务
# dm-auth → dm-user → dm-gateway

# 3. 业务服务（按需）
# dm-course → dm-learning → dm-exam → dm-trade → dm-pay 等

# 4. AI 服务
# dm-aigc
```

### 5. 访问

- **API 文档**：`http://localhost:{port}/doc.html`
- **Gateway 入口**：`http://localhost:10010`

---

## 项目说明

本项目为个人学习与实践作品，基于 Spring Cloud 微服务生态与多智能体 AI 技术构建，涵盖课程、学习、考试、交易、智能问答等完整业务链路，适合学习交流与技术参考。

---

## 许可证

仅供学习参考，请勿用于商业用途。