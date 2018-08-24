//package com.github.wxpay.sdk;
//
//import javax.xml.ws.Action;
//import java.math.RoundingMode;
//import java.text.DecimalFormat;
//
//public class action {
//    private static DecimalFormat df = new DecimalFormat("0.00");
//    @Action("weChatUnifiedorder")
//    public String weChatUnifiedorder(){
//        try {
//            df.setRoundingMode(RoundingMode.HALF_UP);
//// 获取用户ID
//            String memberId = Struts2Utils.getRequest().getParameter("memberId");
//            String integer = Struts2Utils.getRequest().getParameter("integer");
//            String type = Struts2Utils.getRequest().getParameter("type");
////我这里的ip直接从前端页面获取部分手机不能获取
//            String spbill_create_ip = Struts2Utils.getRequest().getParameter("ip");
//            if (StringUtils.isNotBlank(memberId)
//                    && StringUtils.isNotBlank(integer)
//                    && StringUtils.isNotBlank(type)) {
//                Integer score = Integer.valueOf(integer);
//                // 产生订单号
//                String outTradeNo = UuIdUtils.getUUID();
//                // WeixinConfigUtils config = new WeixinConfigUtils();
//                // 参数组
//                String appid = config.appid;
//                String mch_id = config.mch_id;
//                String nonce_str = RandCharsUtils.getRandomString(16);
//                String body = "";
//                if (type.equals("0")) {
//                    body = "购买" + score + "积分,支付" + df.format(score / 100)
//                            + "元";
//                } else if (type.equals("1")) {
//                    body = "购买商品支付" + String.valueOf(score / 100) + "元";
//                }
//                String attach = "暂时无用（这个用于区分不同版本）";
//                String out_trade_no = outTradeNo;
//                int total_fee = score;// 单位是分，现在按照ios传递过来的参数进行
//                String notify_url = config.notify_url;
//                String trade_type = "MWEB";
//                // 参数：开始生成第一次签名
//                parameters.put("appid", appid);
//                parameters.put("mch_id", mch_id);
//                parameters.put("body", body);
//                parameters.put("nonce_str", nonce_str);
//                parameters.put("attach", attach);
//                parameters.put("out_trade_no", out_trade_no);
//                parameters.put("total_fee", total_fee);
//                parameters.put("notify_url", notify_url);
//                parameters.put("trade_type", trade_type);
//                parameters.put("spbill_create_ip", spbill_create_ip);
//                parameters.put("scene_info", "'h5_info':{'type':'Wap','wap_url':'www.abc.com（必须可以直接访问，**这里不要带http://**）','wap_name': '应用名（会在微信订单页显示）'}");
//                String sign = WXSignUtils.createSign("UTF-8", parameters);
//                // 微信统一下单
//                unifiedorder.setAppid(appid);
//                unifiedorder.setMch_id(mch_id);
//                unifiedorder.setNonce_str(nonce_str);
//                unifiedorder.setSign(sign);
//                unifiedorder.setBody(body);
//                unifiedorder.setAttach(attach);
//                unifiedorder.setOut_trade_no(out_trade_no);
//                unifiedorder.setTotal_fee(total_fee);
//                unifiedorder.setSpbill_create_ip(spbill_create_ip);
//                unifiedorder.setNotify_url(notify_url);
//                unifiedorder.setTrade_type(trade_type);
//                unifiedorder.setScene_info("'h5_info':{'type':'Wap','wap_url':'http://www.abc.com（必须可以直接访问**这里不要带http://**）','wap_name': '应用名（会在微信订单页显示）'}");
//                Map<String, String> msgMap = HttpXmlUtils.getUrl(unifiedorder);
//                if (msgMap.get("return_code").equals("SUCCESS") && msgMap.get("result_code").equals("SUCCESS")) {
//                    aLiPay.setApp_id(appid);
//                    aLiPay.setSubject(body);
//                    aLiPay.setScore(integer);
//                    aLiPay.setGmt_create(simpleDateFormat.format(new Date()));
//                    if (null != memberId && !"".equals(memberId)) {
//                        aLiPay.setMember(memberService.getMemberById(Integer
//                                .valueOf(memberId)));
//                    }
//                    aLiPay.setOut_trade_no(out_trade_no);
//                    aLiPay.setPayStatus(PayStatusEnum.WAITPAY.getComment());
//                    aLiPay.setPayType(PayTypeEnum.WEIXIN.getComment());
//                    aLiPay.setState(0);
//                    aLiPay.setTotal_amount(String.valueOf(total_fee / 100));
//                    aLiPay.setSign(sign);
//                    aLiPay.setTotalFee(total_fee);
//                    aLiPayService.addALiPay(aLiPay);
//                    msg.put("ok", true);
//                    //将回调地址发回前端，支付完成后会自动跳转该页面(回调url必须带http://)
//                    msg.put("url", msgMap.get("mweb_url")+"&redirect_url=http://www.jabc.com/member/toMemberIntegral.do");
//                    Struts2Utils.renderJson(msg);
//                }else {
//                    msg.put("ok", false);
//                }
//            }
//            return NONE;
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            return "500";
//        }
//    }
//}
