package mydataharbor.plugin.kafka;

import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.plugin.kafka.sink.KafkaSink;

/**
 * Created by xulang on 2022/1/23.
 */
public class Kafka0xSink extends KafkaSink {
  public Kafka0xSink(KafkaSinkConfig simpleKafkaConfig) {
    super(simpleKafkaConfig);
  }

  @Override
  public String name() {
    return super.name()+"0.x";
  }
}
