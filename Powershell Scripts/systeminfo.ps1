$ul = "___________________________";
$sc = 0;
Start-Transcript -Path "C:\PSLogs\SysInfoSnapshot $(Get-Date -UFormat "%m-%d-%Y ").txt";
"`n System information `n $ul";
Get-CimInstance Win32_OperatingSystem | Select-Object  Caption, InstallDate, ServicePackMajorVersion, OSArchitecture, BootDevice,  BuildNumber, CSName | FL;
"Removable disk space `n $ul"
Get-PSDrive | Where-Object {$_.free -gt 1}| ForEach-Object { Write-Host "Free space for" $_.root "is" ("{0:N2}" -f ($_.Free/1gb )) "GB out of" ("{0:N2}" -f ($_.Used/1gb )) "GB" -ForegroundColor Yellow -BackgroundColor DarkCyan}; 
"`n Currently running services `n $ul"
Get-Service | Where-Object {$_.Status -eq "Running"};
Stop-Transcript;