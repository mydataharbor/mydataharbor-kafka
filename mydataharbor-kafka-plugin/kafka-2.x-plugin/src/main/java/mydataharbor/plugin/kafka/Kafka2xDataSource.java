package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.source.kafka.KafkaDataSource;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka2xDataSource extends KafkaDataSource {
  public Kafka2xDataSource(KafkaDataSourceConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String dataSourceType() {
    return super.dataSourceType()+"2.x";
  }
}
