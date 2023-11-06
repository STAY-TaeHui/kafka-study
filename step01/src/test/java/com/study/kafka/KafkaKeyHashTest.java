package com.study.kafka;

import com.study.kafka.topic.Topic03Config;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.utils.Utils;
import org.junit.jupiter.api.Test;

@Slf4j
class KafkaKeyHashTest {

    @Test
    void keyHashTest() {
        for (int i = 0; i < 10; i++) {
            printHashCode(i);
        }
    }

    private static void printHashCode(int i) {
        String key = Integer.toString(i);
        log.debug("i: {}, hashCode[partition]: {}", i, getHashCode(Topic03Config.TOPIC_03, key, 10));
    }

    public static int getHashCode(String topic, String key, int numPartitions) {
        try {
            byte[] keyBytes = new StringSerializer().serialize(topic, null, key);
            return Utils.toPositive(Utils.murmur2(keyBytes)) % numPartitions;
        } catch (Exception e) {
            return 0;
        }
    }
}
