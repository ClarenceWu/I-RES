graph TD;
  A[客戶] -->|認證| B[資料庫];
  A -->|預約| C[診所];
  A -->|治療項目| B;
  A -->|醫院診所與資訊| B;
  A -->|現在叫號| C;
  A -->|政府補助| B;
  A -->|提醒功能| C;
  A -->|篩選（區域 時間 項目 評價）| B;
  A -->|Deep Seek| B;
  A -->|我的最愛| B;
  A -->|Google 導航| B;
  A -->|出示報到Qrcode| C;

  C -->|叫號更新| A;
  C -->|預約| B;
  C -->|轉診| C;
  C -->|現場 預約的控管| C;
  C -->|主動提醒| A;
  C -->|替使用者預約| A;
  C -->|已預約名單| B;
  C -->|條件式篩選| B;
  C -->|標籤設定| B;
  C -->|Qrcode 憑證| A;
  C -->|查客戶提供的資料| B;
  C -->|知道客戶的病徵| B;
  C -->|上次紀錄（預約紀錄）| B;
  C -->|黑名單注記（鎖 USER 不讓 USER 預約）| B;

  B -->|Google Map| A;
  B -->|類別分類（兒科、耳鼻喉科）| A;

  subgraph 其他功能
    D[有無報到] -->|報到提醒| A;
    E[藥物輔助功能] -->|提供藥物資訊| A;
  end