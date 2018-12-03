//package com.yunguo.service.impl;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.yunguo.domain.Line;
//import com.yunguo.domain.LineStation;
//import com.yunguo.domain.R;
//import com.yunguo.domain.Station;
//import com.yunguo.repository.LineRepository;
//import com.yunguo.repository.LineStationRepository;
//import com.yunguo.repository.StationRepository;
//import com.yunguo.service.LineService;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.io.IOException;
//import java.util.*;
//
//@Service
//public class LineServiceImpl implements LineService {
//
//    @Autowired
//    private LineRepository lineRepository;
//
//    @Autowired
//    private LineStationRepository lineStationRepository;
//
//    @Autowired
//    private StationRepository stationRepository;
//
//
//    @Override
//    @Transactional
//    public R addOrEdit(Line line){
//        line.setUpdateTime(new Date());
//        List<Line> lines = lineRepository.findByLineName(line.getLineName());
//        if(lines==null||lines.size() == 0||(lines.size() == 1&&lines.get(0).getId().equals(line.getId()))){
//            line = lineRepository.save(line);
////            lineStationRepository.deleteByLineId(line.getId());
////            for (int i = 0; i < line.getLineStations().size(); i++) {
////                line.getLineStations().get(i).setLineId(line.getId());
////            }
////            lineStationRepository.save(line.getLineStations());
//            return R.ok();
//        }else {
//            return R.error(300,"线路名称重复");
//        }
//    }
//
//    @Override
//    @Transactional
//    public void del(Integer id) {
//        lineStationRepository.deleteByLineId(id);
//        lineRepository.delete(id);
//    }
//
//    @Override
//    public Line getById(Integer id) {
//        return lineRepository.findOne(id);
//    }
//
//    @Override
//    public Page<Line> findByParam(Map<String, Object> params) {
//        Specification<Line> specification = new Specification<Line>() {
//            @Override
//            public Predicate toPredicate(Root<Line> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//                List<Predicate> predicates = new ArrayList<>(); //所有的断言
//                if(StringUtils.isNotBlank(params.get("name").toString())){ //添加断言
//                    Predicate likeNickName = cb.like(root.get("lineName").as(String.class),"%"+params.get("name").toString()+"%");
//                    predicates.add(likeNickName);
//                    Predicate likeNickName1 = cb.like(root.get("pinyin").as(String.class),"%"+params.get("name").toString()+"%");
//                    predicates.add(likeNickName1);
//                    return cb.or(predicates.toArray(new Predicate[0]));
//                }
////                if(StringUtils.isNotBlank(params.get("orgId").toString())){ //添加断言
////                    Predicate likeNickName = cb.equal(root.get("organId").as(Integer.class),Integer.parseInt(params.get("orgId").toString()));
////                    predicates.add(likeNickName);
////                }
//                return cb.and(predicates.toArray(new Predicate[0]));
//            }
//        };
//        //分页信息
//        Pageable pageable = new PageRequest(Integer.parseInt(params.get("page").toString())-1,Integer.parseInt(params.get("limit").toString())); //页码：前端从1开始，jpa从0开始，做个转换
//        //查询
//        return this.lineRepository.findAll(specification,pageable);
//    }
//
//    @Override
//    public List<LineStation> getUnionInfoById(Integer id) {
//        return lineStationRepository.findByLineId(id);
//    }
//
//    @Override
//    @Transactional
//    public R updateUnionStation(List<LineStation> lineStations) {
//        lineStationRepository.deleteByLineId(lineStations.get(0).getLineId());
//        if(lineStations.size() == 1&& lineStations.get(0).getStationId() == null){
//
//        }else {
//            lineStationRepository.save(lineStations);
//        }
//        return R.ok().put("msg","编辑成功");
//    }
//
//
//
//    /**
//    　* 导入线路
//    　* @return
//    　* @author liangdengjun
//    　* @date 2018/11/23 14:17
//    　*/
//    @Override
//    @Transactional
//    public Map<String, Object> importLines(MultipartFile file) {
//        Map<String, Object> map = new HashMap<>();
//        XSSFWorkbook s;
//        try {
//            s = new XSSFWorkbook(file.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("导入失败");
//        }
//        Sheet sheet = s.getSheetAt(0);
//        String msg = "";
//        for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
//            try {
//                Row row = sheet.getRow(i);
//                Line line = new Line();
//                String lineName = getStringValue(row.getCell(2));
//                List<Line> lines = lineRepository.findLineByLineName(lineName);
//                if(lines == null||lines.size()== 0){
//                    String burum = getStringValue(row.getCell(0));
//                    String bureauNumber = getStringValue(row.getCell(1));
//                    String lineNumber = getStringValue(row.getCell(3));
//                    String unionLineName = getStringValue(row.getCell(4));
//                    String desc = getStringValue(row.getCell(5));
//                    String pinyin = getStringValue(row.getCell(6));
//                    if(burum==null){
//                        msg += "第" + (i + 1) + "行局名为空<br/>";
//                        continue;
//                    }
//                    if(bureauNumber==null){
//                        msg += "第" + (i + 1) + "行局编号为空<br/>";
//                        continue;
//                    }
//                    if(lineName == null){
//                        msg += "第" + (i + 1) + "行线名为空<br/>";
//                        continue;
//                    }
//                    if(lineNumber == null){
//                        msg += "第" + (i + 1) + "行线编号为空<br/>";
//                        continue;
//                    }
//                    if(unionLineName==null){
//                        msg += "第" + (i + 1) + "行关联资源名称为空<br/>";
//                        continue;
//                    }
//                    line.setBureauName(burum);
//                    line.setBureauNumber(bureauNumber);
//                    line.setLineName(lineName);
//                    line.setLineNumber(lineNumber);
//                    line.setPinyin(pinyin);
//                    line.setDesc(desc);
//                    line.setUpdateTime(new Date());
//                    line.setResourceId(lineRepository.getResourceIdByName(unionLineName));
//                    line = lineRepository.save(line);
//                }else {
//                    line = lines.get(0);
//                }
//                String stationName = getStringValue(row.getCell(7));
//                String sort = getStringValue(row.getCell(8));
//                String centerMillige = getStringValue(row.getCell(9));
//                String type = getStringValue(row.getCell(10));
//                String unionDesc = getStringValue(row.getCell(11));
//                if(stationName == null&&(sort!=null||centerMillige!=null||type!=null||unionDesc!=null)){
//                    msg += "第" + (i + 1) + "行关联线路名称为空<br/>";
//                    continue;
//                }
//                LineStation lineStation = new LineStation();
//                List<Station> station = stationRepository.findStationByStationName(stationName);
//                if(station==null||station.size()==0){
//                    msg += "未找到第" + (i + 1) + "行关联车站<br/>";
//                    continue;
//                }
//                lineStation.setLineId(line.getId());
//                lineStation.setCenterMileage(Double.parseDouble(centerMillige));
//                lineStation.setDescri(unionDesc);
//                lineStation.setSort(Integer.parseInt(sort));
//                lineStation.setStationId(station.get(0).getId());
//                lineStation.setType("上行".equals(type)?1:2);
//                lineStationRepository.save(lineStation);
//            } catch (Exception e) {
//                msg += "第" + (i + 1) + "行导入失败<br/>";
//                e.printStackTrace();
//                continue;
//            }
//        }
//        map.put("code", 0);
//        map.put("msg", msg);
//        return map;
//    }
//    private String getStringValue(Cell cell){
//        if(cell == null){
//            return null;
//        }
//        cell.setCellType(XSSFCell.CELL_TYPE_STRING);
//        if(cell.getStringCellValue() == null|| "".equals(cell.getStringCellValue()))
//            return null;
//        return cell.getStringCellValue();
//    }
//
//
//}
