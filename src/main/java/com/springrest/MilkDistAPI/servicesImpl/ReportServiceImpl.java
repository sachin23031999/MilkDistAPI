package com.springrest.MilkDistAPI.servicesImpl;

import com.springrest.MilkDistAPI.Dao.CustomerDao;
import com.springrest.MilkDistAPI.Dao.DailyDistDao;
import com.springrest.MilkDistAPI.Dao.DistReqDao;
import com.springrest.MilkDistAPI.entities.Customer;
import com.springrest.MilkDistAPI.enums.MilkType;
import com.springrest.MilkDistAPI.servicesInterface.ReportService;
import com.springrest.MilkDistAPI.utils.CowBuffalo;
import com.springrest.MilkDistAPI.utils.TotalEarningCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    DailyDistDao dailyDistDao;

    @Autowired
    DistReqDao distReqDao;

    @Override
    public List<CowBuffalo> reportCowVsBuffalo(String start_date, String end_date) {
        Float totalQuantityCow = distReqDao.totalQuantityBetweenDate(start_date, end_date, "cow");
        Float totalQuantityBuffalo = distReqDao.totalQuantityBetweenDate(start_date, end_date, "buffalo");

        Float totalPriceCow = distReqDao.totalPriceBetweenDate(start_date, end_date, "cow");
        Float totalPriceBuffalo = distReqDao.totalPriceBetweenDate(start_date, end_date, "buffalo");

        CowBuffalo cow = new CowBuffalo();
        cow.setType_of_milk(MilkType.cow);
        cow.setTotal_quantity(String.valueOf(totalQuantityCow));
        cow.setTotal_earning(String.valueOf(totalPriceCow));

        CowBuffalo buffalo = new CowBuffalo();
        buffalo.setType_of_milk(MilkType.buffalo);
        buffalo.setTotal_quantity(String.valueOf(totalQuantityBuffalo));
        buffalo.setTotal_earning(String.valueOf(totalPriceBuffalo));

        List<CowBuffalo> cowBuffaloList = new ArrayList<>();
        cowBuffaloList.add(cow);
        cowBuffaloList.add(buffalo);

        return cowBuffaloList;
    }
//    {
//
//        List<ReportQuery> queryListCow = distReqDao.listResultsForCow(start_date, end_date);
//        List<ReportQuery> queryListBuffalo = distReqDao.listResultsForBuffalo(start_date, end_date);
//
//        CowBuffalo cow = new CowBuffalo();
//        float total_quantity = 0, total_price = 0;
//        for(ReportQuery c : queryListCow) {
//            total_quantity += c.getQuantity();
//            total_price += c.getPrice();
//        }
//        cow.setType_of_milk(MilkType.cow);
//        cow.setTotal_quantity(String.valueOf(total_quantity));
//        cow.setTotal_earning(String.valueOf(total_price));
//
//        CowBuffalo buffalo = new CowBuffalo();
//        total_quantity = 0;
//        total_price = 0;
//        for(ReportQuery b : queryListBuffalo) {
//            total_quantity += b.getQuantity();
//            total_price += b.getPrice();
//        }
//        buffalo.setType_of_milk(MilkType.buffalo);
//        buffalo.setTotal_quantity(String.valueOf(total_quantity));
//        buffalo.setTotal_earning(String.valueOf(total_price));
//
//        List<CowBuffalo> list = null;
//        list.add(cow);
//        list.add(buffalo);
//
//        return list;
//    }

    @Override
    public List<TotalEarningCustomer> reportTotalEarning(String start_date, String end_date) {
        List<Customer> customers = customerDao.findAll();

        List<TotalEarningCustomer> list = new ArrayList<>();

        for (Customer c : customers) {
            TotalEarningCustomer earningCustomer = new TotalEarningCustomer();

            //Customer ID
            earningCustomer.setCustomer_id(String.valueOf(c.getId()));


            Float cowQuantity = distReqDao.totalQuantityPerCustomer(start_date, end_date, String.valueOf(c.getId()), "cow");
            Float cowEarning = distReqDao.totalEarningPerCustomer(start_date, end_date, String.valueOf(c.getId()), "cow");
            Float buffaloQuantity = distReqDao.totalQuantityPerCustomer(start_date, end_date, String.valueOf(c.getId()), "buffalo");
            Float buffaloEarning = distReqDao.totalEarningPerCustomer(start_date, end_date, String.valueOf(c.getId()), "buffalo");

            //Total Earning
            if (cowEarning == null && buffaloEarning != null)
                earningCustomer.setTotal_earning(String.valueOf(buffaloEarning));
            else if (cowEarning != null && buffaloEarning == null)
                earningCustomer.setTotal_earning(String.valueOf(cowEarning));
            else if (cowEarning != null && buffaloEarning != null)
                earningCustomer.setTotal_earning(String.valueOf(cowEarning + buffaloEarning));

            CowBuffalo cow = new CowBuffalo(MilkType.cow, String.valueOf(cowQuantity), String.valueOf(cowEarning));
            CowBuffalo buffalo = new CowBuffalo(MilkType.buffalo, String.valueOf(buffaloQuantity), String.valueOf(buffaloEarning));

            //List Cow Buffalo
            List<CowBuffalo> l = new ArrayList<>();
            l.add(cow);
            l.add(buffalo);
            earningCustomer.setDetails(l);

            list.add(earningCustomer);
        }


        return list;
    }
}