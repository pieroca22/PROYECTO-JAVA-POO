@echo off
cd /d "D:\PROYECTO FINAL"
echo ===========================
echo    Actualizando repositorio...
echo ===========================
git add .
git commit -m "Actualización automática"
git push origin master
pause