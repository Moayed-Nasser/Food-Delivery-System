# Food Delivery System - Eclipse Java Project

## طريقة فتح المشروع في Eclipse

1. فك ضغط ملف `FoodDeliverySystemEclipse.zip`، أو استورده مباشرة من ملف ZIP.
2. افتح Eclipse، ثم `File > Import > General > Existing Projects into Workspace`.
3. اختر `Select root directory` وحدد مجلد `FoodDeliverySystemEclipse`، أو `Select archive file` وحدد ملف ZIP.
4. اضغط `Finish`.
5. افتح `src/fooddelivery/Main.java` ثم `Right Click > Run As > Java Application`.
6. لفحص القواعد جميعها: شغّل `FoodDeliveryTests.java` بالطريقة نفسها.

المشروع يعمل على Java 8 أو أحدث، ولا يحتاج أي مكتبات خارجية.

## مثال السؤال

- 2 Burger Meals: (8 + 1.5) × 2 = 19.00
- 1 Large Juice: (3 + 1) × 1 = 4.00
- Subtotal = 23.00
- Express delivery = 5.00
- Total = 28.00
- Card payment = 28 × 1.02 = **28.56**

## أين الكلاسات؟

- `MenuItem`: Abstract Class
- `Meal`, `Drink`: Inheritance + Override
- `DeliveryOption`: Interface
- `StandardDelivery`, `ExpressDelivery`: Implements
- `PaymentMethod`: Interface
- `CashPayment`, `CardPayment`: Implements
- `Order`: يحتوي قائمة `OrderLine`، والـ static order counter، وحالة الطلب
- `OrderLine`: عنصر وكمية
- `OrderStatus`: Enum
- `Main`: مثال التشغيل
- `FoodDeliveryTests`: اختبارات بدون JUnit

## قواعد الحالة

- الإضافة والدفع متاحان فقط عندما يكون الطلب `NEW`.
- لا يمكن دفع طلب فارغ (يضمن سطر طلب واحدًا على الأقل عند الدفع).
- الدفع يحول الحالة إلى `PAID`.
- التوصيل مسموح فقط في حالة `PAID`.
- الإلغاء مسموح فقط في حالة `NEW`.

> ملاحظة مهمة: ورقة السؤال الأصلية تطلب رسم UML، وليس كتابة Java. أُرفق رسم UML داخل `docs/`، وهذا المشروع البرمجي تنفيذ إضافي لتجربته على Eclipse.
