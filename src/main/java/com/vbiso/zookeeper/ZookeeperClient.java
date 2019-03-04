package com.vbiso.zookeeper;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 11:31 PM 2019/2/15
 * @Modified By:
 */
public class ZookeeperClient {

  private static final String addr = "127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183,127.0.0.1:2184";


  public static void main(String[] args) throws InterruptedException {
    ZkClient zkClient = new ZkClient(addr, 6000, 6000);
    zkClient.subscribeChildChanges("/vbiso-1", (parentPath, currentChilds) -> {
      System.out.println("subscribe child changes" + parentPath);
      System.out.println("subscribe child changes" + currentChilds);
    });

    zkClient.subscribeDataChanges("/vbiso-1", new IZkDataListener() {
      @Override
      public void handleDataChange(String dataPath, Object data) {
        System.out.println("handle data change" + dataPath);
        System.out.println("handle data change" + data);
      }

      @Override
      public void handleDataDeleted(String dataPath) {
        System.out.println("handle Data Deleted:" + dataPath);
      }
    });

    zkClient.subscribeStateChanges(new IZkStateListener() {
      @Override
      public void handleStateChanged(KeeperState state) {
        System.out.println("handle state changed" + state);
      }

      @Override
      public void handleNewSession() {
      }
    });

    if (zkClient.exists("/vbiso-1/test1")) {
      zkClient.delete("/vbiso-1/test1");
    }
    TimeUnit.SECONDS.sleep(2);
    zkClient.createEphemeral("/vbiso-1/test1");
    TimeUnit.SECONDS.sleep(2);
    zkClient.delete("/vbiso-1/test1");
    TimeUnit.SECONDS.sleep(2);
    zkClient.createPersistent("/vbiso-1/test1", "test");
    TimeUnit.SECONDS.sleep(2);
    zkClient.createEphemeral("/vbiso-1/test2", "test2");
    TimeUnit.SECONDS.sleep(2);
    List<String> children = zkClient.getChildren("/");
    System.out.println(children);
    TimeUnit.SECONDS.sleep(2);
  }

}
