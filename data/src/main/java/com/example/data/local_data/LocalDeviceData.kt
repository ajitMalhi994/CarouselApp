package com.example.data.local_data

import com.example.data.entity.Device
import com.example.data.entity.DeviceDescription
import com.example.data.entity.DeviceType

class LocalDeviceData {

    val deviceDataList = listOf(
        Device("https://img.freepik.com/premium-photo/logo-text-android-with-illustration-rainbow-colored-android-head-white-background_734511-20163.jpg", DeviceType.ANDROID),
        Device("https://i.pinimg.com/736x/18/69/87/186987a4d6a6d45a4bcbd7dbc8074837.jpg", DeviceType.IPHONE),
        Device("https://cdn.rios.hu/dl/cnt/2008-10/37630/windowsmobilelogo.jpg", DeviceType.WINDOWS)
    )

    val android = listOf(
        DeviceDescription("https://tinyurl.com/2s35zya4", "Samsung Galaxy S21"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Google Pixel 6"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "OnePlus 9"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Xiaomi Mi 11"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Sony Xperia 5 II"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Oppo Find X3 Pro"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Huawei P40 Pro"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Asus ROG Phone 5"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Realme GT"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Motorola Edge Plus"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Nokia 8.3 5G"),
        DeviceDescription("https://tinyurl.com/2s35zya4", "Vivo X60 Pro")
    )

    val iphone = listOf(
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 13 Pro"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 13"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 12 Pro"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 12"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 11 Pro"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 11"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone XS Max"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone XS"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone XR"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone X"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 8 Plus"),
        DeviceDescription("https://tinyurl.com/ypwxb7wn", "iPhone 8")
    )

    val windows = listOf(
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 950 XL"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 950"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 930"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 920"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 830"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 730"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 640 XL"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 640"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 535"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 1020"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 520"),
        DeviceDescription("https://tinyurl.com/mphbm97j", "Lumia 435")
    )

}
