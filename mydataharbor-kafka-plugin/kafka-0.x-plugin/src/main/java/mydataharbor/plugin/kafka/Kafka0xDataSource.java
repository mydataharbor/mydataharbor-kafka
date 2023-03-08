package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.plugin.kafka.source.KafkaDataSource;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka0xDataSource extends KafkaDataSource {
  public Kafka0xDataSource(KafkaDataSourceConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String dataSourceType() {
    return super.dataSourceType()+"0.x";
  }
}
