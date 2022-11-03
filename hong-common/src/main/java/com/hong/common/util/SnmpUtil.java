package com.hong.common.util;


import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.Vector;

/**
 * @Author: ZhangDeHong
 * @Describe: TODO
 * @Date Create by  14:21 2022/10/29
 */
public class SnmpUtil {

    public static void main (String[] args) throws IOException {
        //目标机器地址，SNMP默认端口号为161
        Address targetAddress = GenericAddress.parse("udp:127.0.0.1/161");

        //构建SNMP对象，该对象中有用于SNMP的相关方法
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();

        CommunityTarget target = new CommunityTarget();
        //在机器上配置好的团体字
        target.setCommunity(new

                OctetString("SA19225338"));

        //设置基本信息
        target.setAddress(targetAddress);
        target.setRetries(2);//重试次数
        target.setTimeout(1500);//超时时间
        target.setVersion(SnmpConstants.version2c);//SNMP版本

        PDU pdu = new PDU();
        // 系统描述信息OID
        pdu.add(new
                VariableBinding(new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 1, 0})));
        // 系统开机时间OID
        pdu.add(new
                VariableBinding(new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 3, 0})));
        pdu.setType(PDU.GET);
        ResponseEvent event = snmp.send(pdu, target);

        if (event != null && event.getResponse() != null) {
            //得到返回信息的集合
            Vector<VariableBinding> recVBs = (Vector<VariableBinding>) event.getResponse().getVariableBindings();
            //遍历返回信息
            for (int i = 0; i < recVBs.size(); i++) {
                VariableBinding recVB = recVBs.elementAt(i);
                System.out.println(recVB.getOid() + " : " + recVB.getVariable());
            }
        }
        snmp.close();
    }
}
