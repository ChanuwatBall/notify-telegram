# Java spring boot send notifications to telegram chat group
#### สร้าง Bot ใหม่ของตัวเอง
1. เพิ่ม Contact ค้นหา BotFather แล้วเพิ่มเพื่อน
2. ทำตามคำสั่งเริ่มต้น
    - พิมพ์ /newbot ~ จากนั้นก็ตั้งชื้อ bot โดยชื่อจะต้องลงท้าย. ด้วยคำว่า Bot ซึ่งชื่อจะต้องไม่ซ้ำ
    - เมื่อสร้าง Bot สำเร็จ จะได้ Bot Token จากนั้นก็เก็บ Bot Token ไว้ให้ปลอดภัยเพื่อนำไปใช้งานต่อ

#### เมื่อมี Bot ของตัวเองแล้ว<br/>
3. สร้าง Group ของคุณให้เรียบร้อย<br/>
4. เพิ่ม Member เป็น Bot ที่สร้าง แล้วตั้ง Bot เป็น Admin.<br/>
5. ค้นหา chat Id เข้าไปที่ clickalgo.com/telegram-chatid แล้วนำ BotToken  วางในช่องแล้วกด Get chat ID
เลื่อนมาดานล่าง หา "chat" { "id" และ " title" } ที่ตรงกับชื่อแชทที่ต้องการ แล้วบันทึก id ดังกล่าวไว้ใช้งาน

## Config
add application.properties
```bash
telegram.bot.token=YourBotToken
```

## API Telegram Notify 
Send Message
```bash
CURL  -X GET  http://api-telegram.andamantracking.com/app/api/send-message
-d "chatId":-1002260381583
-d "messag":"test "
```

Send Photo
```bash
CURL  -X POST  http://api-telegram.andamantracking.com/app/api/send-message
-d "chatId":-1002260381583
--header "photo":"https://www.canva.com/"  
``` 
