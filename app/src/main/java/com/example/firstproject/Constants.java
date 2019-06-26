package com.example.firstproject;

import com.amap.api.maps.model.LatLng;

/**
 * Created by DengShuai on 2019/1/30.
 * Description :
 */
public class Constants {
    public static final int LOCAL = 0;
    public static final int NETWORK = 1;
    public static final int TYPE_CHECK = 1;
    public static final int TYPE_REPAIR = 2;
    public static final String BASE_URL = "http://180.167.216.66:8084/";
    public static final String BASE_URL_FILE = "http://180.167.216.66:8084/FtpFile/";
    //public static final String BASE_MAP_URL="http://116.228.206.210:6080/arcgis/rest/services/cnBasemap20180817/MapServer";
    public static final String BASE_MAP_URL="http://192.168.200.22:6080/arcgis/rest/services/DJB_Background_jkx/MapServer";
    public static final String RED_LINE_URL="http://116.228.206.210:6080/arcgis/rest/services/cnfzx/MapServer/1";
    //public static final String POINT_QUERY_URL="http://116.228.206.210:6080/arcgis/rest/services/20180914/MapServer/1";
    //public static final String LINE_QUERY_URL="http://116.228.206.210:6080/arcgis/rest/services/20180914/MapServer/4";
    //public static final String SURFACE_QUERY_URL="http://116.228.206.210:6080/arcgis/rest/services/20180914/MapServer/6";
    //
    public static final String POINT_QUERY_URL="http://180.167.216.66:6080/arcgis/rest/services/20190402/MapServer/1";
    public static final String LINE_QUERY_URL="http://180.167.216.66:6080/arcgis/rest/services/20190402/MapServer/2";
    public static final String SURFACE_QUERY_URL="http://180.167.216.66:6080/arcgis/rest/services/20190402/MapServer/3";




    public static final String URL_Convert="http://180.167.216.66:8084/";//from=sh&to=gcj02&locations=
    //public static final String URL_Convert_TOSH="http://192.168.200.33/threeapi2/api/convert?from=gcj02&to=sh&locations=";


    //public static final LatLng SHANGHAI = new LatLng(31.238068, 121.501654);// 上海市经纬度
    public static final LatLng SHANGHAI = new LatLng(31.1988,121.420531);// 长宁
    //FTP
    public static final String FTP_HOST_DEFAULT = "180.167.216.66";
    public static final int FTP_HOST_PORT = 13000;//9004
    public static final String FTP_USER_DEFAULT = "cn";
    public static final String FTP_PASSWORD_DEFAULT = "123456";

    public static final String FTP_CONNECT_SUCCESS = "ftp连接成功";
    public static final String FTP_CONNECT_FAIL = "ftp连接失败";
    public static final String FTP_DISCONNECT_SUCCESS = "ftp断开连接";
    public static final String FTP_FILE_NOTEXISTS = "ftp上文件不存在";

    public static final String FTP_UPLOAD_SUCCESS = "ftp文件上传成功";
    public static final String FTP_UPLOAD_FAIL = "ftp文件上传失败";
    public static final String FTP_UPLOAD_LOADING = "ftp文件正在上传";

    public static final String FTP_DOWN_LOADING = "ftp文件正在下载";
    public static final String FTP_DOWN_SUCCESS = "ftp文件下载成功";
    public static final String FTP_DOWN_FAIL = "ftp文件下载失败";

    public static final String FTP_DELETEFILE_SUCCESS = "ftp文件删除成功";
    public static final String FTP_DELETEFILE_FAIL = "ftp文件删除失败";

    public static final String FTP_GETALLPICPATH_SUCCESS = "ftp获取所有图片路径成功";
    public static final String FTP_GETALLPICPATH_FAIL = "ftp获取所有图片路径失败";
}
