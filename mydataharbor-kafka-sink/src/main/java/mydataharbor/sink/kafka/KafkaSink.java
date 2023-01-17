package mydataharbor.sink.kafka;

import lombok.extern.slf4j.Slf4j;
import mydataharbor.IDataSink;
import mydataharbor.exception.ResetException;
import mydataharbor.kafka.common.sink.KafkaSinkReq;
import mydataharbor.kafka.common.sink.KafkaSinkConfig;
import mydataharbor.setting.BaseSettingContext;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * Created by xulang on 2021/8/20.
 */
@Slf4j
public class KafkaSink implements IDataSink<KafkaSinkReq, BaseSettingContext> {

  private final KafkaProducer<String, String> kafkaProducer;

  private KafkaSinkConfig simpleKafkaConfig;

  public KafkaSink(KafkaSinkConfig simpleKafkaConfig) {
    this.simpleKafkaConfig = simpleKafkaConfig;
    Properties kafkaConfig = new Properties();
    kafkaConfig.put("bootstrap.servers", simpleKafkaConfig.getBootstrapServers());
    if (simpleKafkaConfig.getKafkaConfig() != null)
      kafkaConfig.putAll(simpleKafkaConfig.getKafkaConfig());
    kafkaConfig.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    kafkaConfig.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    this.kafkaProducer = new KafkaProducer(kafkaConfig);
  }

  @Override
  public String name() {
    return "kafka-sink-";
  }

  @Override
  public WriterResult write(KafkaSinkReq record, BaseSettingContext settingContext) throws ResetException {
    ProducerRecord<String, String> kafkaRecord = new ProducerRecord<>(simpleKafkaConfig.getTopic(), record.getKey(), record.getValue());
    if (record.getHeader() != null) {
      for (String key : record.getHeader().keySet()) {
        kafkaRecord.headers().add(key, record.getHeader().get(key).getBytes());
      }
    }
    Object sinkReturn;
    try {
      Future<RecordMetadata> recordMetadataFuture = kafkaProducer.send(kafkaRecord);
      sinkReturn = recordMetadataFuture;
      if (simpleKafkaConfig.isSync()) {
        RecordMetadata recordMetadata = recordMetadataFuture.get();
        sinkReturn = recordMetadata;
      }
    } catch (Exception e) {
      log.error("发送消息失败！", e);
      return WriterResult.builder().success(false).commit(false).msg(e.getMessage()).build();
    }
    return WriterResult.builder().success(true).commit(true).msg("ok").writeReturn(sinkReturn).build();
  }

  @Override
  public WriterResult write(List<KafkaSinkReq> records, BaseSettingContext settingContext) throws ResetException {
    List<Object> sinkReturnList = new ArrayList<>();
    for (KafkaSinkReq record : records) {
      ProducerRecord<String, String> kafkaRecord = new ProducerRecord<>(simpleKafkaConfig.getTopic(), record.getKey(), record.getValue());
      if (record.getHeader() != null) {
        for (String key : record.getHeader().keySet()) {
          kafkaRecord.headers().add(key, record.getHeader().get(key).getBytes());
        }
      }
      Object sinkReturn;
      try {
        Future<RecordMetadata> recordMetadataFuture = kafkaProducer.send(kafkaRecord);
        sinkReturn = recordMetadataFuture;
        if (simpleKafkaConfig.isSync()) {
          RecordMetadata recordMetadata = recordMetadataFuture.get();
          sinkReturn = recordMetadata;
        }
        sinkReturnList.add(sinkReturn);
      } catch (Exception e) {
        log.error("发送消息失败！", e);
        return WriterResult.builder().success(false).commit(false).msg(e.getMessage()).build();
      }
    }
    return WriterResult.builder().success(true).commit(true).msg("ok").writeReturn(sinkReturnList).build();
  }

  @Override
  public void close() throws IOException {
    kafkaProducer.close();
  }
}
