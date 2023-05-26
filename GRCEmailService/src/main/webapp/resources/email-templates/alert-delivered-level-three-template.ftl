<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>   
</head>
<body style="margin: 0; padding: 0;">
Dear Mr/Ms <b>${employeeName!'-'}</b>,<br>
<br>
Your colleagues have submitted <b>${alertDeliveredCount!'-'} EWS alerts</b> for <b>${customersCount} customers</b> for the date of ${alertDate?date!'-'}. 
Your prompt action in this regard would be appreciated. In the event of non-attending alerts within stipulated time lines, the same will be escalated to higher authorities.
<br>
<br>
<table id="alertDeliveredToL3" border="1">
    <tr>
        <th width="10%">Employee Id</th>
        <th width="10%">Employee Name</th>
         <th width="10%">Customer Id</th>
        <th width="10%">Customer Name</th>
        <th width="30%">Alert Description</th>
        <th width="10%">Status</th>
        <th width="10%">Action</th>
        <th width="10%">Remarks by L2</th>
    </tr>
    <#list alertDelivered as alert>
        <tr>
            <td class="name">${alert.recentlyActedUserId?capitalize}</td>
            <td>${alert.recentlyActedUserName!'-'}</td>
            <td>${alert.customerId}</td>
            <td>${alert.customerName}</td>
            <td>${alert.message}</td>
            <td>${alert.status}</td>
            <td>${alert.action}</td>
            <td>${alert.recentRemarks!'-'}</td>
        </tr>
    </#list>
</table>
<br>
Regards,<br>
EWS Team, ${department!'-'},<br>
Head Office, ${branchCity!'-'},<br>
${bankName!'-'}<br>
<br>
<b>Caution Notice: This is a system generated alert. Kindly do not respond to this.</b>
</body>
</html>
