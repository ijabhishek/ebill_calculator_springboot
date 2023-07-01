
package com.eblill.calculator.ebillcontroller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EbillController {

    @GetMapping("/")
    public String showForm() {
        return "bill-form";
    }

    @PostMapping("/calculate")
    public String calculateBill(
            @RequestParam("room1_new_bill_reading") int room1NewBillReading,
            @RequestParam("room1_old_bill_reading") int room1OldBillReading,
            @RequestParam("room2_new_bill_reading") int room2NewBillReading,
            @RequestParam("room2_old_bill_reading") int room2OldBillReading,
            @RequestParam("room3_new_bill_reading") int room3NewBillReading,
            @RequestParam("room3_old_bill_reading") int room3OldBillReading,
            @RequestParam("motar_new_bill_reading") int motarNewBillReading,
            @RequestParam("motar_old_bill_reading") int motarOldBillReading,
            @RequestParam("total_bill_amount") double totalBillAmount,
            @RequestParam("water_bill_amount") double waterBillAmount,
            @RequestParam("other_expenses") double otherExpenses,
            @RequestParam("due_date") String dueDate,
            Model model
    ) {
        // Calculate units consumed by each person
        int room1UnitsConsumed = room1NewBillReading - room1OldBillReading;
        int room2UnitsConsumed = room2NewBillReading - room2OldBillReading;
        int room3UnitsConsumed = room3NewBillReading - room3OldBillReading;
        int motarUnitsConsumed = motarNewBillReading - motarOldBillReading;

        // Calculate the total units consumed
        int totalUnitsConsumed = room1UnitsConsumed + room2UnitsConsumed +
                room3UnitsConsumed + motarUnitsConsumed;
        double avgBillAmount = totalBillAmount/totalUnitsConsumed;
        double motarBillAmount = (motarUnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount;

        // Here *1000 and /1000 means I want 3 decimal point like -> 1.565
        double motarBillAmountPerPerson = (double) Math.round((motarBillAmount / 3) * 1000) /1000;
        double waterBillAmountPerPerson = (double) Math.round((waterBillAmount / 3) * 1000) /1000;
        double otherExpensesPerPerson = (double) Math.round((otherExpenses / 3) * 1000) /1000;

        // Bill amount before adding water bill, motarbill and anyother expenses r1 - room1
        double r1 = (double) Math.round(((room1UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount) * 1000) /1000;
        double r2 = (double) Math.round(((room2UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount)*1000)/1000;
        double r3 = (double) Math.round(((room3UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount)*1000)/1000;;


        // Calculate the individual bill amount
        int room1BillAmount = (int)Math.round(((room1UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount) + (motarBillAmountPerPerson +waterBillAmountPerPerson + otherExpensesPerPerson));
        int room2BillAmount = (int)Math.round(((room2UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount) + (motarBillAmountPerPerson + waterBillAmountPerPerson + otherExpensesPerPerson));
        int room3BillAmount = (int)Math.round(((room3UnitsConsumed / (double) totalUnitsConsumed) * totalBillAmount) + (motarBillAmountPerPerson + waterBillAmountPerPerson + otherExpensesPerPerson));

        // Pass the bill amounts to the result page
        model.addAttribute("room1_new_bill_reading", room1NewBillReading);
        model.addAttribute("room1_old_bill_reading", room1OldBillReading);
        model.addAttribute("room2_new_bill_reading", room2NewBillReading);
        model.addAttribute("room2_old_bill_reading", room2OldBillReading);
        model.addAttribute("room3_new_bill_reading", room3NewBillReading);
        model.addAttribute("room3_old_bill_reading", room3OldBillReading);
        model.addAttribute("motar_new_bill_reading", motarNewBillReading);
        model.addAttribute("motar_old_bill_reading", motarOldBillReading);
        model.addAttribute("total_bill_amount",totalBillAmount);
        model.addAttribute("room1_bill_before_any_addon", r1);
        model.addAttribute("room2_bill_before_any_addon", r2);
        model.addAttribute("room3_bill_before_any_addon", r3);
        model.addAttribute("due_date",dueDate);

        model.addAttribute("room1BillAmount", room1BillAmount);
        model.addAttribute("room2BillAmount", room2BillAmount);
        model.addAttribute("room3BillAmount", room3BillAmount);
        model.addAttribute("motarBillAmount", motarBillAmount);
        model.addAttribute(("motarBillAmountPerPerson"), motarBillAmountPerPerson);
        model.addAttribute("waterBillAmount",waterBillAmount);
        model.addAttribute("waterBillAmountPerPerson",waterBillAmountPerPerson);
        model.addAttribute("otherExpenses",otherExpenses);
        model.addAttribute("otherExpensesPerPerson", otherExpensesPerPerson);
        model.addAttribute("avgBillAmount", avgBillAmount);

        return "result";
    }
}
