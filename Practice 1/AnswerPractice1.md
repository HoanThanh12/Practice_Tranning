# Answer Practice 1

# Question 1: Hàm onload sẽ bắt đầu chạy khi nào ?

- Hàm onload chạy khi mình load page lên

# Question 2: f_cmd có nghĩa là gì, nó dùng để làm gì ?

- f_cmd dùng cho server biết event đó làm gì
- f_cmd là một hidden element nó định nghĩa cho value của button
- Có thể tìm thấy các sample code trong file CoFormControl.js

# Question 3: Hàm này dùng để làm gì, và nó có cần thiết hay không? Tại sao?

![Question3](../../Hinh/QS3.png)

- Hàm này bản chất của nó là 1 Contructor
- Dùng để tiện gọi và thao tác với những tham số này
- Nó không cần thiết
- Vì giống như trong java

# Question 4: Có cần thiết phải lúc nào cũng xài hết function này hay không và tại sao?

![Question3](../../Hinh/QS4.png)

- Có, vì tất cả hàm này đều được sử dụng trong view của practice 1, và có vẻ như được thiết kế theo rule của framework

# Question 5: Hàm ComConfigSheet và ComEndConfigSheet dùng để làm gì, và nếu không sử dụng thì sẽ xảy ra việc gì?

## ComConfigSheet

- Thiết lập design basic cho sheet. function phải dc gọi trước khi init sheet
- Ví dụ các thuộc tính size chữ, hiện thị dropdown button....
  value/status

## ComEndConfigSheet

- Kết lại những thiết lập cho sheet
  Set những ability của đối tượng, ví dụ behavior, colorchange, editable behavior.

## Nếu không có thì sẽ run các config với default

# Question 6: Sự khác nhau và giống nhau của LoadSearchData và GetSearchData?

- GetSearcData chỉ lấy data về dạng XML
- LoadSearchDta hiển thị data get được

# Question 7: Dòng 110 headTitle: dấu "|" dùng để làm gì. Có cần thiết khi thêm | ở phía trước hay không và nếu không thêm thì chuyện gì sẽ xảy ra? Dòng 112: giải thích các số ở trong SetConfig. Dòng 118 --> 125: giải thích keyfied, format dùng để làm gì? Nếu không muốn cho user update cell, add data khi insert dòng mới thì làm như thế nào? Làm thế nào chỉ cho phép cell đó được nhập ký tự hoặc là số?

![Question3](../../Hinh/QS7.png)

- Dòng 110: dấu "|" dùng đế kết hợp tên các cột khi khởi tạo bảng trong hàm InitHeaders. Cần thiết phải thêm dấu này ở phía trước vì có 1 cột status đầu tiên là hidden nên cột tên Del phải ở vị trí 2 trên header, nếu k thì cột tên Del sẽ được gán cho cột dữ liệu đầu tiên và sẽ bị ẩn đi.
- Dòng 112: Define các thông số thuộc tính khởi tạo cho header
- Dòng 118:
- Keyfield: đánh dấu cột đó có required field hay không(boolean) mới được save
- Format: Định dạng dữ liệu hiển thị trên sheet
- Dùng AcceptKeys để gán constrain cho input là chữ hoặc số

# Question 8: Giải thích formObj.f_cmd.value = SEARCH: dùng để làm gì?

- Định nghĩa value button của nó là SEARCH, dùng để server hiểu cần làm gì

# Question 9: Phân biệt sự khác nhau giữa DelCheck và CheckBox, nó có các trạng thái nào? Khi nào sử dụng DelCheck và khi nào thì sử dụng CheckBox?

## DelCheck

- DelCheck chỉ phục vụ cho chức năng mark đơn vị sẽ bị xóa

## CheckBox

- Checkbox có thể quy định cho nhiều trạng thái, ví dụ update, boolean, delete check.

# Question 10: Giải thích luồng đi của chức năng search (BE)

- Nhận request từ Client thì vào HtmlAction, xử lý và trả xuống SC, SC trả xuống cho BCImpl thao tác xong trả ngược dần lên FE

# Question 11: Làm sao để FW biết chạy từ HtmlAction xuống SC

- Do sử dụng mappings để điều hướng nó

# Question 12: Transaction trong OPUS được viết như thế nào?

- Trong hàm EventResponse manageErrMsg trong file SC bao gồm 3 method bên trong
  begin(), commit(), rollback()

# Question 13: Làm thế nào để nhận biết Record nào sẽ là insert, update hay delete ở BCImpl?

- get Ibflag của từng object, để xác định key
  Ví dụ "I" là insert "D" là delete…

# Question 14: Validate ở server side được thực hiện như thế nào?

- Tạo 1 hàm check ở BCImpl cho truyền vào 1 Msg Code
- Sử dụng hàm search để thử select dữ liệu ở database (file bcimpl)
- Có tồn tại dữ liệu thì throw duplicate
- Không thì tiếp tục insert

# Question 15: Nếu thêm 1 option search nữa (cụ thể là search description) thì cần sửa những file nào?

- Sửa ở JSP, HtmlAction , file SQL (thêm điều kiện)

# Question 16: Dòng "WHERE 1 = 1" thường được dùng để làm gì?

- Chỉ một điều kiện luôn true. Tránh lỗi syntax trong lúc viết Where có if, and

# Question 17: Phân biệt velParam và param?

## velParam

- Syntax : ${value}
- Thì sẽ thêm dấu nháy đơn ' ' cho string
- Giá trị mình truyền cho UI xong UI gửi xuống Query hoặc BE

## param

- Syntax : @[value]
- Thường dùng để check điều kiện #if #end
- Giá trị từ UI nhận được truyền vào Query hoặc BE
