/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.datamoin.tajo.tpcds;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tajo.LocalTajoTestingUtility;
import org.apache.tajo.client.TajoClient;
import org.apache.tajo.client.TajoClientImpl;
import org.apache.tajo.conf.TajoConf;
import org.apache.tajo.conf.TajoConf.ConfVars;
import org.apache.tajo.service.ServiceTrackerFactory;
import org.apache.tajo.util.FileUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class TpcDSRemoteTest extends TpcDsTest {
  private static final Log LOG = LogFactory.getLog(TpcDSRemoteTest.class);

  @BeforeClass
  public static void beforeClass() {
    try {
      databaseName = TpcDSTestUtil.getDatabaseName();

      TajoConf tajoConf = new TajoConf();
      tajoConf.setVar(ConfVars.TAJO_MASTER_CLIENT_RPC_ADDRESS, TpcDSTestUtil.getTajoMaster());

      client = new TajoClientImpl(ServiceTrackerFactory.get(tajoConf), "default");
      TpcDSTestUtil.createTables(databaseName, client);

      client.selectDatabase(databaseName);
    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
      fail(e.getMessage());
    }
  }

  @AfterClass
  public static void afterClass() throws Exception {
    client.close();

    System.out.println("=================================================");
    System.out.println("Test time: " + (endTime - startTime) / 1000 + " sec");
    System.out.println("Succeeded queries: " + successQueries.size() + "/" + numTargetQueries);
    System.out.println("-------------------------------------------------");
    for (String eachQuery: successQueries) {
      System.out.println(eachQuery);
    }
    System.out.println("=================================================");

  }

  @Test
  public void testRemote() throws Exception {
    super.testAllQueries(false);
  }
}
