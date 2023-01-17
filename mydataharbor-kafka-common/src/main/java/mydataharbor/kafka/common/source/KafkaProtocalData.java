package mydataharbor.kafka.common.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import mydataharbor.IProtocolData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xulang on 2021/8/22.
 */
@Data
public class KafkaProtocalData implements IProtocolData {

  private String topic;

  private String key;

  private String value;

  private Map<String, byte[]> header = new HashMap<>();

  @Override
  public String protocolName() {
    return "kafka-protocal-data";
  }

}
