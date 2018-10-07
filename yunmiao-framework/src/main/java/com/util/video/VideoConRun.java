package com.util.video;

import com.base.dao.model.BFile;
import com.base.service.BFileService;
import com.util.PaidangConst;

import java.io.File;
import java.util.Date;

public class VideoConRun implements Runnable{

    private FFMpegUtil ffMpegUtil;
    private String path;
    private String fileName;
    private String realdir;
    private BFileService fileService;

    public VideoConRun(FFMpegUtil ffMpegUtil, String path, String realdir, String fileName, BFileService fileService){
        this.ffMpegUtil = ffMpegUtil;
        this.path = path;
        this.fileName = fileName;
        this.fileService = fileService;
        this.realdir = realdir;
    }

    @Override
    public void run() {
        //视频压缩
        String normalVideoName = fileName+PaidangConst.VIDEO_NORMAL+".mp4";
        File normalVideo = new File(path,normalVideoName);
        ffMpegUtil.videoTransfer(normalVideo);
        BFile normal = new BFile();
        normal.setFileId(fileName+PaidangConst.VIDEO_NORMAL);
        normal.setFileMinitype("video/mp4");
        normal.setFilePath(realdir + "/" + normalVideoName);
        normal.setFileState(1);
        normal.setFileCreatetime(new Date());
        normal.setFileName(normalVideoName);
        normal.setFileCreater("640x360");
        normal.setFileBelong(BFileService.LOCAL);
        fileService.insert(normal);

    }
}
