package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.sink.kafka.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka1xSink extends KafkaSink {
  public Kafka1xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String name() {
    return super.name()+"1.x";
  }
}
