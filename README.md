# mydataharbor-kafka
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
    "speed": 100,
    "url": "",
    "username": "",
    "password": "",
    "querySql": "",
    "maxPollRecords": 1,
    "model": "INCREMENT",
    "countSql": "",
    "rollingFieldName": "updated_at",
    "startTime": "2021-02-22 15:47:00",
    "timeFormat": "yyyy-MM-dd HH:mm:ss",
    "primaryKeys": [
      "id"
    ]
  }
```

## Sink配置

```json
{
    "url": "",
    "username": "",
    "password": "",
    "defaultTableName": ""
  }
```

