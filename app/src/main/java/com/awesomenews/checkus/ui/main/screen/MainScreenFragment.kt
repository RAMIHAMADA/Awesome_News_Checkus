package com.awesomenews.checkus.ui.main.screen

import android.icu.text.IDNA
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.awesomenews.checkus.adapters.CardNewsAdapter
import com.awesomenews.checkus.databinding.FragmentMainScreenBinding
import com.awesomenews.checkus.models.InfoModel

class MainScreenFragment : Fragment() {
    private lateinit var adapter: CardNewsAdapter
    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


    private fun initAdapter() {
        adapter = CardNewsAdapter(object : CardNewsAdapter.Listener {
            override fun onClickInfoModel(infoModel: InfoModel) {
                navigateTo(infoModel)
            }
        })
        binding.recyclerViewMainScreen.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMainScreen.adapter = adapter

        val list = mutableListOf(
            InfoModel(
                "Microsoft начала тестировать на обычных пользователях новый Bing с полноценной версией ИИ-бота ChatGPT",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081909/3dnews_new_bing_01.jpg",
                140220023,
                "Microsoft начала рассылать приглашения для тестирования полноценной настольной версии поисковика Bing с интегрированным ИИ-чат-ботом ChatGPT."
            ),
            InfoModel(
                "Российским покупателям OnePlus 11 заблокировали звонки, потому что смартфон «адаптирован для другого региона»",
                "https://3dnews.ru/assets/external/illustrations/2023/02/13/1081907/OnePlus_11_lock_01.jpg",
                140220023,
                "OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах.OnePlus начала блокировать функцию звонков в своих смартфонах, выпущенных для китайского рынка, но активированных в других регионах."
            ),
            InfoModel(
                "Информационная безопасность: десять неутешительных прогнозов на 2023 год",
                "https://3dnews.ru/assets/external/illustrations/2023/02/05/1081436/cybersecurity-predictions-2023-1.png",
                140220023,
                "Так уж повелось, что сегмент кибербезопасности скуп на позитивные перемены, и наступивший год не станет исключением из правил."
            ),
            InfoModel(
                "Обзор смартфона Google Pixel 7 Pro: главный андроид",
                "https://3dnews.ru/assets/external/icons/2023/01/22/1080690.jpg",
                140220023,
                "В прошлом году, на фоне известных событий и ухода в «серую зону» даже таких брендов, как Samsung и Apple, аппараты Google Pixel получили буквально второе дыхание."
            ),
            InfoModel(
                "Компьютер месяца — февраль 2023 года",
                "https://3dnews.ru/assets/external/icons/2023/02/04/1081413.jpg",
                140220023, "В феврале в продаже появилось много новых комплектующих."
            ),
            InfoModel(
                "Apple обучила iPhone не путать зимние виды спорта с ДТП и сломала Google Фото для iOS",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081922/crash-detection.jpg",
                140220023,
                "С обновлением iOS 16.3.1 компания Apple «оптимизировала» функцию Crash Detection в iPhone 14."
            ),
            InfoModel(
                "BYD потратит $1,2 млрд на строительство нового завода тяговых батарей в Китае",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081920/byd_01.jpg",
                140220023,
                "Основанная в 1995 году китайская компания BYD выпускает транспортные средства с 2003 года."
            ),
            InfoModel(
                "Новое предприятие в Мичигане позволит Ford расширить использование LFP-аккумуляторов",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081912/ford_01.jpg",
                140220023,
                "Намерения Ford освоить в Мичигане выпуск литиевых аккумуляторов с фосфатом железа по технологиям китайской CATL не были тайной с минувших выходных, но только в понедельник американский автогигант подтвердил запустить это производство к 2026 году."
            ),
            InfoModel(
                "Китайский разработчик процессоров UNISOC намерен привлечь $1,5 млрд инвестиций",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081927/unisoc_01.jpg",
                140220023,
                "Шанхайская компания UNISOC в прошлом году формально избавилась от опеки холдинга Tsinghua Unigroup и теперь принадлежит частному фонду Wise Road Capital, но это не мешает данному разработчику процессоров строить планы по своей интеграции в программу импортозамещения. "
            ),
            InfoModel(
                "В ОАЭ появится собственная цифровая валюта",
                "https://3dnews.ru/assets/external/illustrations/2023/02/14/1081931/dubai.jpg",
                140220023,
                "В Объединённых Арабских Эмиратах (ОАЭ) появится собственная цифровая валюта — она и ряд других проектов помогут стране стать «обществом без наличных»."
            ),
        )
        adapter.submitList(list)
    }
    // осуществлена навигация с фрагмента MainScreenFragment на DetailsNewsFragment
    private fun navigateTo(news_detalis: InfoModel) {
        findNavController().navigate(
            MainScreenFragmentDirections.actionMainScreenFragmentToDetailsNewsFragment(
                newsDetalis = news_detalis
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}