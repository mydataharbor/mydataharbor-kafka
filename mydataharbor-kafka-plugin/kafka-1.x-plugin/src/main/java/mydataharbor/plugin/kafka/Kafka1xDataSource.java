package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.plugin.kafka.source.KafkaDataSource;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka1xDataSource extends KafkaDataSource {
  public Kafka1xDataSource(KafkaDataSourceConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String dataSourceType() {
    return super.dataSourceType()+"1.x";
  }
}
