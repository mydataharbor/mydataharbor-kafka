package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.source.KafkaDataSourceConfig;
import mydataharbor.source.kafka.KafkaDataSource;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka10xDataSource extends KafkaDataSource {
  public Kafka10xDataSource(KafkaDataSourceConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }
}
