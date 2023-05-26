<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>   
</head>
<body style="margin: 0; padding: 0;">
Dear Mr/Ms <b>${employeeName!'-'}</b>,<br>
<br>
Your supervisor has rejected <b>${alertDeliveredCount} EWS alerts</b> for <b>${customersCount} customers</b> for the date of <b>${alertDate?date}</b>. 
Your prompt action in this regard would be appreciated. In the event of non-attending alerts within stipulated time lines, the same will be escalated to higher authorities.
<br>
<br>
<table id="alertList" border="1">
    <tr>        
        <th width="10%">Customer Id</th>
        <th width="10%">Customer Name</th>
        <th width="30%">Alert Description</th>
        <th width="10%">Status</th>
        <th width="10%">Action</th>
        <th width="10%">Rejecting Remarks by L4</th>
    </tr>
    <#list alertDelivered as alert>
        <tr>           
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
