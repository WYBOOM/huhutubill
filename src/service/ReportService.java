package service;
 
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
 
import dao.RecordDAO;
import entity.record;
import util.DateUtil;
 
public class ReportService {
 
    /**
     * 获取某一天的消费金额
     * @param d
     * @param monthRawData
     * @return
     */
    public int getDaySpend(Date d,List<record> monthRawData){
        int daySpend = 0;
        for (record record : monthRawData) {
            if(record.date.equals(d))
                daySpend+=record.spend;
        }
        return daySpend;
    }
         
    /**
     * 获取一个月的消费记录集合
     * @return
     */
    public List<record> listThisMonthRecords() {
        RecordDAO dao= new RecordDAO();
        List<record> monthRawData= dao.listThisMonth();
        List<record> result= new ArrayList<>();
        Date monthBegin = DateUtil.monthBegin();
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        Calendar c = Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            record r = new record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE, i);
            Date eachDayOfThisMonth=c.getTime() ;
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            r.spend=daySpend;
            result.add(r);
        }
        return result;
 
    }
 
}