namespace graduation_Project
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form2));
            this.ForgetPassLabel = new System.Windows.Forms.Label();
            this.password_txt_login = new System.Windows.Forms.TextBox();
            this.AdminestratorT = new System.Windows.Forms.Label();
            this.AdminestratorPicB_LogIn = new System.Windows.Forms.PictureBox();
            this.LogInButton = new System.Windows.Forms.Button();
            this.checkBxShowPas = new System.Windows.Forms.CheckBox();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.username_txt_login = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.AdminestratorPicB_LogIn)).BeginInit();
            this.SuspendLayout();
            // 
            // ForgetPassLabel
            // 
            this.ForgetPassLabel.AutoSize = true;
            this.ForgetPassLabel.Cursor = System.Windows.Forms.Cursors.Hand;
            this.ForgetPassLabel.Font = new System.Drawing.Font("Nirmala UI", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point);
            this.ForgetPassLabel.ForeColor = System.Drawing.Color.DeepSkyBlue;
            this.ForgetPassLabel.Location = new System.Drawing.Point(112, 533);
            this.ForgetPassLabel.Name = "ForgetPassLabel";
            this.ForgetPassLabel.Size = new System.Drawing.Size(118, 20);
            this.ForgetPassLabel.TabIndex = 12;
            this.ForgetPassLabel.Text = "Forget Password";
            this.ForgetPassLabel.Click += new System.EventHandler(this.label2_Click);
            // 
            // password_txt_login
            // 
            this.password_txt_login.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(231)))), ((int)(((byte)(233)))));
            this.password_txt_login.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.password_txt_login.Font = new System.Drawing.Font("Rockwell", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point);
            this.password_txt_login.ForeColor = System.Drawing.Color.DodgerBlue;
            this.password_txt_login.Location = new System.Drawing.Point(76, 462);
            this.password_txt_login.Name = "password_txt_login";
            this.password_txt_login.PasswordChar = '*';
            this.password_txt_login.PlaceholderText = "Password";
            this.password_txt_login.Size = new System.Drawing.Size(216, 19);
            this.password_txt_login.TabIndex = 11;
            this.password_txt_login.UseSystemPasswordChar = true;
            // 
            // AdminestratorT
            // 
            this.AdminestratorT.AutoSize = true;
            this.AdminestratorT.Font = new System.Drawing.Font("Vivaldi", 14.25F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Bold | System.Drawing.FontStyle.Italic))), System.Drawing.GraphicsUnit.Point);
            this.AdminestratorT.Location = new System.Drawing.Point(151, 88);
            this.AdminestratorT.Name = "AdminestratorT";
            this.AdminestratorT.Size = new System.Drawing.Size(104, 22);
            this.AdminestratorT.TabIndex = 10;
            this.AdminestratorT.Text = "Administrator";
            this.AdminestratorT.Click += new System.EventHandler(this.label1_Click);
            // 
            // AdminestratorPicB_LogIn
            // 
            this.AdminestratorPicB_LogIn.Image = ((System.Drawing.Image)(resources.GetObject("AdminestratorPicB_LogIn.Image")));
            this.AdminestratorPicB_LogIn.Location = new System.Drawing.Point(137, 31);
            this.AdminestratorPicB_LogIn.Name = "AdminestratorPicB_LogIn";
            this.AdminestratorPicB_LogIn.Size = new System.Drawing.Size(127, 54);
            this.AdminestratorPicB_LogIn.SizeMode = System.Windows.Forms.PictureBoxSizeMode.Zoom;
            this.AdminestratorPicB_LogIn.TabIndex = 9;
            this.AdminestratorPicB_LogIn.TabStop = false;
            // 
            // LogInButton
            // 
            this.LogInButton.BackColor = System.Drawing.Color.DeepSkyBlue;
            this.LogInButton.Cursor = System.Windows.Forms.Cursors.Hand;
            this.LogInButton.FlatAppearance.BorderSize = 0;
            this.LogInButton.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.LogInButton.Font = new System.Drawing.Font("Nirmala UI", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point);
            this.LogInButton.ForeColor = System.Drawing.Color.White;
            this.LogInButton.Location = new System.Drawing.Point(112, 497);
            this.LogInButton.Name = "LogInButton";
            this.LogInButton.Size = new System.Drawing.Size(118, 29);
            this.LogInButton.TabIndex = 20;
            this.LogInButton.Text = "LOGIN";
            this.LogInButton.UseVisualStyleBackColor = false;
            this.LogInButton.Click += new System.EventHandler(this.button1_Click);
            // 
            // checkBxShowPas
            // 
            this.checkBxShowPas.AutoSize = true;
            this.checkBxShowPas.Cursor = System.Windows.Forms.Cursors.Hand;
            this.checkBxShowPas.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.checkBxShowPas.Location = new System.Drawing.Point(260, 479);
            this.checkBxShowPas.Name = "checkBxShowPas";
            this.checkBxShowPas.Size = new System.Drawing.Size(105, 19);
            this.checkBxShowPas.TabIndex = 21;
            this.checkBxShowPas.Text = "Show Password";
            this.checkBxShowPas.UseVisualStyleBackColor = true;
            // 
            // username_txt_login
            // 
            this.username_txt_login.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(231)))), ((int)(((byte)(233)))));
            this.username_txt_login.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.username_txt_login.Font = new System.Drawing.Font("Rockwell", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point);
            this.username_txt_login.ForeColor = System.Drawing.Color.DodgerBlue;
            this.username_txt_login.Location = new System.Drawing.Point(76, 428);
            this.username_txt_login.Name = "username_txt_login";
            this.username_txt_login.PlaceholderText = "Username";
            this.username_txt_login.Size = new System.Drawing.Size(216, 19);
            this.username_txt_login.TabIndex = 22;
            this.username_txt_login.UseSystemPasswordChar = true;
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Zoom;
            this.ClientSize = new System.Drawing.Size(394, 557);
            this.Controls.Add(this.username_txt_login);
            this.Controls.Add(this.checkBxShowPas);
            this.Controls.Add(this.LogInButton);
            this.Controls.Add(this.ForgetPassLabel);
            this.Controls.Add(this.password_txt_login);
            this.Controls.Add(this.AdminestratorT);
            this.Controls.Add(this.AdminestratorPicB_LogIn);
            this.DoubleBuffered = true;
            this.Name = "Form2";
            this.Text = "Login";
            this.Load += new System.EventHandler(this.Form2_Load);
            ((System.ComponentModel.ISupportInitialize)(this.AdminestratorPicB_LogIn)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Label ForgetPassLabel;
        private TextBox password_txt_login;
        private Label AdminestratorT;
        private PictureBox AdminestratorPicB_LogIn;
        private Button LogInButton;
        private CheckBox checkBxShowPas;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private TextBox username_txt_login;
    }
}