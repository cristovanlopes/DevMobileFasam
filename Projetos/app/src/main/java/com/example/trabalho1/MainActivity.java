package com.example.trabalho1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnPower, btnVolumeUp, btnVolumeDown, btnChannelUp, btnChannelDown;
    private TextView tvChannelInfo;
    private boolean isPowerOn = false;
    private int volume = 10;
    private int currentChannelIndex = 0;
    private List<Channel> channels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPower = findViewById(R.id.btnPower);
        btnVolumeUp = findViewById(R.id.btnVolumeUp);
        btnVolumeDown = findViewById(R.id.btnVolumeDown);
        btnChannelUp = findViewById(R.id.btnChannelUp);
        btnChannelDown = findViewById(R.id.btnChannelDown);
        tvChannelInfo = findViewById(R.id.tvChannelInfo);

        // Inicializa a lista de canais
        initializeChannels();

        updateChannelInfo();

        btnPower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePower();
            }
        });

        btnVolumeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseVolume();
            }
        });

        btnVolumeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseVolume();
            }
        });

        btnChannelUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseChannel();
            }
        });

        btnChannelDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseChannel();
            }
        });
    }

    private void togglePower() {
        isPowerOn = !isPowerOn;
        if (isPowerOn) {
            showToast("TV ligada");
        } else {
            showToast("TV desligada");
        }
    }

    private void increaseVolume() {
        if (isPowerOn && volume < 100) {
            volume++;
            showToast("Volume aumentado: " + volume);
        }
    }

    private void decreaseVolume() {
        if (isPowerOn && volume > 0) {
            volume--;
            showToast("Volume diminuído: " + volume);
        }
    }

    private void increaseChannel() {
        if (isPowerOn && currentChannelIndex < channels.size() - 1) {
            currentChannelIndex++;
            updateChannelInfo();
        }
    }

    private void decreaseChannel() {
        if (isPowerOn && currentChannelIndex > 0) {
            currentChannelIndex--;
            updateChannelInfo();
        }
    }

    private void updateChannelInfo() {
        Channel currentChannel = channels.get(currentChannelIndex);
        String channelInfo = "Canal atual: " + currentChannel.getNumber() + " - " + currentChannel.getName() + "\n";

        if (currentChannelIndex > 0) {
            Channel previousChannel = channels.get(currentChannelIndex - 1);
            channelInfo += "Canal anterior: " + previousChannel.getNumber() + " - " + previousChannel.getName() + "\n";
        }

        if (currentChannelIndex < channels.size() - 1) {
            Channel nextChannel = channels.get(currentChannelIndex + 1);
            channelInfo += "Próximo canal: " + nextChannel.getNumber() + " - " + nextChannel.getName();
        }

        tvChannelInfo.setText(channelInfo);
    }

    private void initializeChannels() {
        channels = new ArrayList<>();
        channels.add(new Channel(1, "Globo"));
        channels.add(new Channel(2, "SBT"));
        channels.add(new Channel(3, "Record"));
        channels.add(new Channel(4, "Band"));
        channels.add(new Channel(5, "RedeTV!"));
        channels.add(new Channel(6, "TV Cultura"));
        channels.add(new Channel(7, "TV Gazeta"));
        channels.add(new Channel(8, "TV Brasil"));
        channels.add(new Channel(9, "Canal Futura"));
        channels.add(new Channel(10, "TV Senado"));
        channels.add(new Channel(11, "TV Câmara"));
        channels.add(new Channel(12, "CNN Brasil"));
        channels.add(new Channel(13, "BandNews TV"));
        channels.add(new Channel(14, "GloboNews"));
        channels.add(new Channel(15, "Record News"));
        channels.add(new Channel(16, "Rede Vida"));
        channels.add(new Channel(17, "MTV"));
        channels.add(new Channel(18, "TNT"));
        channels.add(new Channel(19, "AXN"));
        channels.add(new Channel(20, "Warner Channel"));
        channels.add(new Channel(21, "Universal TV"));
        channels.add(new Channel(22, "Fox Channel"));
        channels.add(new Channel(23, "Fox Life"));
        channels.add(new Channel(24, "Sony Channel"));
        channels.add(new Channel(25, "TCM"));
        channels.add(new Channel(26, "Discovery Channel"));
        channels.add(new Channel(27, "National Geographic"));
        channels.add(new Channel(28, "Animal Planet"));
        channels.add(new Channel(29, "History"));
        channels.add(new Channel(30, "A&E"));
        channels.add(new Channel(31, "Discovery Home & Health"));
        channels.add(new Channel(32, "GNT"));
        channels.add(new Channel(33, "Viva"));
        channels.add(new Channel(34, "Multishow"));
        channels.add(new Channel(35, "Space"));
        channels.add(new Channel(36, "FX"));
        channels.add(new Channel(37, "Syfy"));
        channels.add(new Channel(38, "TBS"));
        channels.add(new Channel(39, "AMC"));
        channels.add(new Channel(40, "E!"));
        channels.add(new Channel(41, "MTV Live HD"));
        channels.add(new Channel(42, "ESPN"));
        channels.add(new Channel(43, "Fox Sports"));
        channels.add(new Channel(44, "BandSports"));
        channels.add(new Channel(45, "SporTV"));
        channels.add(new Channel(46, "Premiere"));
        channels.add(new Channel(47, "Combate"));
        channels.add(new Channel(48, "ESPN Brasil"));
        channels.add(new Channel(49, "ESPN 2"));
        channels.add(new Channel(50, "ESPN Extra"));
        channels.add(new Channel(51, "ESPN 3"));
        channels.add(new Channel(52, "Discovery Turbo"));
        channels.add(new Channel(53, "Discovery Science"));
        channels.add(new Channel(54, "Discovery Civilization"));
        channels.add(new Channel(55, "Discovery Theater"));
        channels.add(new Channel(56, "Discovery World"));
        channels.add(new Channel(57, "ID"));
        channels.add(new Channel(58, "Investigação Discovery"));
        channels.add(new Channel(59, "NatGeo Kids"));
        channels.add(new Channel(60, "Nickelodeon"));
        channels.add(new Channel(61, "Cartoon Network"));
        channels.add(new Channel(62, "Boomerang"));
        channels.add(new Channel(63, "Tooncast"));
        channels.add(new Channel(64, "Disney Channel"));
        channels.add(new Channel(65, "Disney XD"));
        channels.add(new Channel(66, "Disney Junior"));
        channels.add(new Channel(67, "Nick Jr."));
        channels.add(new Channel(68, "BabyTV"));
        channels.add(new Channel(69, "TLC"));
        channels.add(new Channel(70, "Eurosport"));
        // Adicione mais canais conforme necessário
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public static class Channel {
        private final int number;
        private final String name;

        public Channel(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }
    }

}
