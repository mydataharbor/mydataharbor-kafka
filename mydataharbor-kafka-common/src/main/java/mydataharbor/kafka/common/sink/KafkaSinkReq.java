package mydataharbor.kafka.common.sink;

import lombok.Data;

import java.util.Map;

/**
 * Created by xulang on 2021/8/20.
 */
@Data
public class KafkaSinkReq {
  private String key;

  private String value;

  private Map<String, String> header;
}
