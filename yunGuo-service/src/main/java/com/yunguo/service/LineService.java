//package com.yunguo.service;
//
//import org.springframework.data.domain.Page;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import com.yunguo.domain.Line;
//import com.yunguo.domain.LineStation;
//import com.yunguo.domain.R;
//
//import java.util.List;
//import java.util.Map;
//
//public interface LineService {
//    R addOrEdit(Line line);
//
//    void del(Integer id);
//
//    Line getById(Integer id);
//
//    Page<Line> findByParam(Map<String, Object> params);
//
//    List<LineStation> getUnionInfoById(Integer id);
//
//    R updateUnionStation(List<LineStation> lineStations);
//
//    Map<String, Object> importLines(MultipartFile file);
//}
