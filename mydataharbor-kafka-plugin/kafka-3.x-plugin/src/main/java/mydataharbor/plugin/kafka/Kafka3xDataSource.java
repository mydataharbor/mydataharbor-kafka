package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.plugin.kafka.source.KafkaDataSource;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka3xDataSource extends KafkaDataSource {
  public Kafka3xDataSource(KafkaDataSourceConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String dataSourceType() {
    return super.dataSourceType()+"3.x";
  }
}
