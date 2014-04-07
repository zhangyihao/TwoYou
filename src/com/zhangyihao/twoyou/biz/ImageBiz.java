package com.zhangyihao.twoyou.biz;

import java.util.Map;

public interface ImageBiz {
	Map<String, Object> getImages(int rquestNum, int page);
	Map<String, Object> getImagesByTag(String tag, int rquestNum, int page);
}