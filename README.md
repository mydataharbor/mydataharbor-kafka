# mydataharbor-kafka
# 作者

MyDataHarbor([1053618636@qq.com](mailto:1053618636@qq.com))

# 项目介绍

该项目是为MyDataHarbor实现kafka的DataSource 和 Sink，让使用者可以从kafka抽取数据，或者将数据写入kafka。

# 实现版本

| 中间件/协议 | 数据源（DataSource） | 写入源（Sink） |
| ----------- | -------------------- | -------------- |
| kafka       | ✅全部版本            | ✅全部版本      |

# 配置

## DataSource配置

```json
{
    "topics": [],
    "kafkaConfig": {}
  }
```

## Sink配置

```json
{
    "topic": "",
    "kafkaConfig": {},
    "sync": true
  }
```

