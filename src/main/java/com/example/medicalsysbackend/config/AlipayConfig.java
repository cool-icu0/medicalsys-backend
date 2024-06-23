package com.example.medicalsysbackend.config;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000131685112";
    // 商户私钥，您的PKCS8格式RSA2私钥，支付宝开发平台助手生成的私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAtcPbKqfH2zFf0+akMdmkjvyNJ+Z/A1l6WpenIiCyvKFX5KunkAy1AYgATxoVt9OI4pzWds+qvRWl+8fXPop5X3jJHtM2a6jkiID5FR2KzgeAATbwH0jlI1uhiG6aEBdObvNG4gCusDZqChSwgDkr1mMxx+u9bzwU0osoaVwcAPP9QoXFXDn2ur7VyQQNInVsABg576Lxaja5GPWBXqkFMKf2djsaUZtuPufn/wyOTsUdBQ0fvBb3O9OUEKrMyb5wy0SrxwWDZNWvSfsgRmGg1SpaF9xTvinAR/F5ZkJMLeLjccScnd6joe0//oOSsw1zR9pDSPF/0+yqZOG1yl/JAgMBAAECggEAay1wu1dIwX7AHakJfR7ZulMq8KwSHx/96Yn4kL81dUDoJZWQbwbf3fY5dvBnq0AZEPqLWXc0NFwh48bGwXEdxDYBEZDulnmN+UfGBiRUJlqsGiZoxgl3HP+VdOx0FSxjC/gN8q+Nm+m2VhSw58zOTrfGgBSXNHalFD3CjVM21UWy5pMk0w81ka/GJwdkKWHuLWzkDwVLVMa+T1JZAKQobKm6PeK0WEck6cuymFtxFP4LLqUtN1pvAwimjmDTsr3wZasgzuR6RNSxOJ4OtMESgZTW78vz98h4FdJBTkEmmpgQYXeRMJTKdqz73ejLs1xuzBrM7roql+uY8GHWZtWm0QKBgQDCNVwDyNBGIuS81bYOTGFaPc/FU83iPGc5xEGNcjLYOjjK4zK5phCaJIU/1drfCOh/p7x7iT6ULmzTqpXqUyo9qfwuQ0cXJ0aoLGuMD8vxc76QY6OOfwGKdmQJmaKY492mfoQ0Qz4Q1iy68l/K/gUUHHdGnAH5x9eo/Z5w0P4MTQKBgQCpqW/lFQm+DjHUWnr//o/hmhNwdQa+x1zEoIN5Zt0AnQYx5io+ZsxGMGyKONUMbwXj05krZIh8a9g6jIfrRdTyUFh1zulZsnDx5aBe8UGZ6v7kDuZCDtPhcaY226+K+UQKHmKwgUaSLaAKjW7KYw7VD7YEL+t7ozjo6NbddVEvbQKBgBvxvZm1zXIqFyusvJN2HhP0DO9hzaAd/ORs/tmxcut2BTH8WxIneQAU/S9gQCwThhDIO/CyoNSFkZcrVoLvEIbq7KRjfdkxB5OvQJJYu4m0k9kG3UPltn0L5/0RpDnHn98TGUbD3ixiBPGpams0/doU9nysegRM4xUn2SJ2j/eJAoGBAI7SPIiKkj30cwwA8uQG5hYS/uQ/D2OQLc60FJkg90/p32ooCE2pebJoVyZwOyCRYVLtMFZv9dlPa6G15UEv8tfcvOrHOHaymRN4quzhiMjKIrHWvQzEsKZqZnJtsrN5rEYcWBWfbcnmMIBRmP80Lis7Y4zYzhGxUFn4j8+zT5ltAoGACwYT+088Pc36SApqOi0XE1gZUnXP9Y9bE+Br4RxESHngsDXZ1YI8GLy0ZnA11ozvq1fxCsTsGGVYZcuDoqbkvTjRWpjLQMZrjzXezVedYWrYaY95yZKwey+R9DUO6jHdGGCcN6NJzyeXm195RnzDOURTVBSIoqRorGCcX0Bah4g=";
    // 支付宝公钥,
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy7HG9VSCAcHSUeIw+hPYGcg2Zl6kPsxs34cr0UriCHExmtQI9fEoFs6zNHdcChtBMoT1s7f30BUByg3/opSHAIrHnVli9zYczEylZvfWcGprldew+R+8vK/BQKRaVlxsne6riwVzbHrtAvJqiRM8DZdOarjt/P8KsUAcq86YY+C4KI2516n/pzHv/zrltvGWv9r/xa6k6callArcDTrwLuLlC3kcHkHs7wbbC08K6IcjLTdfq+F3VONfBfakECLGlWQjN+fnAcEXUJ3qxkHOoBtVlEoA8N8nffGtIT+QPVtaokVKOIDmfRhdKiwftr8RTZKm0oNzqZHUh8VE0p7CxwIDAQAB";
    public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url";
    public static String return_url = " http://47.98.213.9:8039/api/v1/pay/return_sult";
    // 签名方式，注意这里，如果步骤设置的是RSA则用RSA
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
    // 支付宝网关
    public static String log_path = "D:\\";
}